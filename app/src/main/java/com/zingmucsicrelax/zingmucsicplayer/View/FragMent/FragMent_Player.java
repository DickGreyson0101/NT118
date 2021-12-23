package com.zingmucsicrelax.zingmucsicplayer.View.FragMent;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;
import com.zingmucsicrelax.zingmucsicplayer.Controller.BaiHatController;
import com.zingmucsicrelax.zingmucsicplayer.Controller.UserController;
import com.zingmucsicrelax.zingmucsicplayer.Model.BaiHat;
import com.zingmucsicrelax.zingmucsicplayer.Model.Playlist;
import com.zingmucsicrelax.zingmucsicplayer.R;
import com.zingmucsicrelax.zingmucsicplayer.ShareConfig;
import com.zingmucsicrelax.zingmucsicplayer.View.Account.DangNhapActivity;
import com.zingmucsicrelax.zingmucsicplayer.View.Player.PlayMusicActivity;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FragMent_Player  extends Fragment {
    View view;
    int check = 0;
    private ArrayList<BaiHat> arrayList;
    private  TextView txttencasi,txttenbaihat,txtthoigianbaihat,txtthoigianbatdau;
    private  ImageView player;
    private  ImageView next;
    private  ImageView previous;
    private  ImageView love;
    private  ImageView loop;
    private  ImageView back;
    private  SeekBar seek_duration;
    private  CircleImageView image_avartar;
    private  MediaPlayer mp;
    private  BaiHatController baiHatController;
    private  ArrayList<BaiHat> baiHats;
    private  int k = 0;
    private  int check_loop = 0;
    private ShareConfig shareConfig;
    private UserController userController;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_player,container,false);
        InitWidget();
        BaiHat baiHat = PlayMusicActivity.baiHat;

        Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.rotate_animation);

        shareConfig = new ShareConfig(getContext());
        image_avartar.startAnimation(animation);
       baiHatController = new BaiHatController();
        userController = new UserController(getContext());

        if(PlayMusicActivity.type==0){
            arrayList = baiHatController.getDataListBH();
        }else if(PlayMusicActivity.type ==1){
            arrayList = baiHatController.getDataListBaiHatYeuThich(shareConfig.getUserID());
        }else if(PlayMusicActivity.type ==3){
            arrayList = baiHatController.getDataListBaiHatPlayList(shareConfig.getUserID(),baiHat.getId_playlist());
        }



      for(int i = 0 ;i <arrayList.size();i++){

          if(arrayList.get(i).getTenbaihat().equalsIgnoreCase(baiHat.getTenbaihat())){
              k = i;
          }

      }

        PlayMusic(arrayList.get(k).getUrl_baihat(),arrayList.get(k).getTenbaihat(),arrayList.get(k).getLoibaihat(),
              arrayList.get(k).getHinhanh(),arrayList.get(k).getTencasi());
      next.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if(mp.isPlaying()){
                  mp.stop();
              }
              if(k>=arrayList.size()-1){
                 k=0;
              }else{
                  k++;
              }
              PlayMusic(arrayList.get(k).getUrl_baihat(),arrayList.get(k).getTenbaihat(),arrayList.get(k).getLoibaihat(),
                      arrayList.get(k).getHinhanh(),arrayList.get(k).getTencasi());
          }
      });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp.isPlaying()){
                    mp.stop();
                }
                if(k>0 ){
                    k--;
                }else{
                   k = 0;
                }
                PlayMusic(arrayList.get(k).getUrl_baihat(),arrayList.get(k).getTenbaihat(),arrayList.get(k).getLoibaihat(),
                        arrayList.get(k).getHinhanh(),arrayList.get(k).getTencasi());
            }
        });
        loop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (check_loop){
                    case  0:
                        loop.setImageResource(R.drawable.ic_baseline_loop_true);
                        check_loop  =1;
                        mp.setLooping(true);
                        break;
                    case 1:
                        mp.setLooping(false);
                        loop.setImageResource(R.drawable.ic_baseline_loop_24);
                        check_loop  =0;break;
                }
            }
        });
        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shareConfig.getUserID()>0){

                    PopupMenu popupMenu = new PopupMenu(getContext(),love);
                    popupMenu.inflate(R.menu.menu_poup);
                    Menu menu = popupMenu.getMenu();

                  popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                      @Override
                      public boolean onMenuItemClick(MenuItem item) {
                          switch (item.getItemId()){
                              case R.id.love: userController.ThemMucBaiHatYeuThich(arrayList.get(k).getId(),shareConfig.getUserID());break;
                              case R.id.playlist: DiaLogPlayList();break;
                          }
                          return true;
                      }
                  });
                    popupMenu.show();

                }else{
                    if(mp.isPlaying()){
                        mp.stop();
                    }
                    startActivity(new Intent(getContext(), DangNhapActivity.class));
                    getActivity().finish();
                }
            }
        });
 back.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         if(mp.isPlaying()){
             mp.stop();
             getActivity().finish();
         }else{
             getActivity().finish();
         }
     }
 });





        return  view;
    }

    private void DiaLogPlayList() {
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_playlist);

        ListView lv = dialog.findViewById(R.id.lv);
        ArrayList<Playlist>playlists = baiHatController.getDataPlayList(shareConfig.getUserID());
        List<String> list = new ArrayList<>();
        if(arrayList.size()>0){
            for(Playlist p : playlists){
                list.add(p.getTenplaylist());
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,list);
            lv.setAdapter(arrayAdapter);
            dialog.show();
        }else{
            Toast.makeText(getContext(), "Play list chưa được khởi tạo", Toast.LENGTH_SHORT).show();
        }
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                userController.ThembaiHatVaoPlayList(playlists.get(position).getId(),
                        arrayList.get(k).getId());
                dialog.cancel();



            }
        });




    }

    private void InitWidget() {
        txttencasi= view.findViewById(R.id.txtencasi);
        txttenbaihat= view.findViewById(R.id.txttenbaihat);
        txtthoigianbaihat= view.findViewById(R.id.txtthoigianbaihat);
        txtthoigianbatdau= view.findViewById(R.id.txtthoigianbatdau);
        player = view.findViewById(R.id.play);
        next = view.findViewById(R.id.next);
        previous = view.findViewById(R.id.previous);
        seek_duration = view.findViewById(R.id.seek_duration);
        image_avartar = view.findViewById(R.id.avatar_cs);
        love = view.findViewById(R.id.love);
        loop = view.findViewById(R.id.loop);
        back = view.findViewById(R.id.back);
    }

    private void PlayMusic(String url_baihat, String tenbaihat, String loibaihat, String hinhanh,String tencasi) {
        txttenbaihat.setText(tenbaihat);
        txttencasi.setText(tencasi);
        Picasso.with(getContext()).load(hinhanh).into(image_avartar);

        FragMent_Lyrics.txtlyrics.setText(loibaihat);
        mp = new MediaPlayer();


        try {

            mp.setDataSource(url_baihat);
            mp.prepare();
            mp.start();;
            if(check_loop ==1){
                mp.setLooping(true);
            }else{
                mp.setLooping(false);
            }
            player.setImageResource(R.drawable.ic_baseline_pause_circle_outline_24);
        } catch (IOException e) {
            e.printStackTrace();
        }

        seek_duration.setProgress(0);
        seek_duration.setMax(mp.getDuration());
        seek_duration.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                mp.seekTo(seekBar.getProgress());

            }
        });


        player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (check){
                    case  0: player.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                        if(mp.isPlaying()){
                            mp.pause();
                        }
                        check = 1;break;
                    case 1:
                        player.setImageResource(R.drawable.ic_baseline_pause_circle_outline_24);
                        if(mp.isPlaying()){


                        }else{

                            mp.start();
                        }
                        check =0;break;
                }
            }
        });
        UpdateTimer();

    }

    private void UpdateTimer() {
        Handler handler = new Handler();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        txtthoigianbaihat.setText(simpleDateFormat.format(mp.getDuration()));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                txtthoigianbatdau.setText(simpleDateFormat.format(mp.getCurrentPosition()));
                seek_duration.setProgress(mp.getCurrentPosition());
              if(check_loop==1){

              }else{
                  if(seek_duration.getProgress()==mp.getDuration()){
                      if(k>=arrayList.size()-1){
                          k=0;
                      }else{
                          k++;
                      }
                      PlayMusic(arrayList.get(k).getUrl_baihat(),arrayList.get(k).getTenbaihat(),arrayList.get(k).getLoibaihat(),
                              arrayList.get(k).getHinhanh(),arrayList.get(k).getTencasi());
                  }
              }

                handler.postDelayed(this,100);

            }
        },100);
    }

}
