package com.zingmucsicrelax.zingmucsicplayer.View.PlayList;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zingmucsicrelax.zingmucsicplayer.Adapter.DanhSachBaiHatYeuThichAdapter;
import com.zingmucsicrelax.zingmucsicplayer.Controller.BaiHatController;
import com.zingmucsicrelax.zingmucsicplayer.Controller.UserController;
import com.zingmucsicrelax.zingmucsicplayer.Model.BaiHat;
import com.zingmucsicrelax.zingmucsicplayer.Model.Playlist;
import com.zingmucsicrelax.zingmucsicplayer.R;
import com.zingmucsicrelax.zingmucsicplayer.ShareConfig;

import java.util.ArrayList;
import java.util.List;

public class DanhSachPlayListActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView lv;
    private DanhSachBaiHatYeuThichAdapter adapter;
    private ArrayAdapter arrayAdapter;
    private BaiHatController baiHatController;
    private  ArrayList<Playlist> arrayList;
    private List<String> list_play;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_playlist);
        lv=findViewById(R.id.lv);
        //Hiển thị toolbar
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Play List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            } //Nút back
        });
        baiHatController = new BaiHatController();
        UserController userController = new UserController(this);
        ShareConfig shareConfig = new ShareConfig(this); // Lấy Id người dùng
        arrayList = baiHatController.getDataPlayList(shareConfig.getUserID()); //Lấy danh sách playlist theo id
        list_play =new ArrayList<>();
        //adđ vào arrylist
         for(Playlist p : arrayList){
             list_play.add(p.getTenplaylist());

         }
         arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,list_play); //Đưa vào adapter để hiển thị

        lv.setAdapter(arrayAdapter);
        //Xử lý nút thêm playlist
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              ShowDiaLogAdd(userController);
            }
        });
        //Xử lý khi nhấn vào 1 playlist
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(arrayList.size()>0){
                    Intent intent = new Intent(DanhSachPlayListActivity.this,DanhSachBaiHatPlayListActivity.class);
                    intent.putExtra("PLAY",arrayList.get(position)); //Truyền playlist sang activity mới
                    startActivity(intent);
                }else{
                    Toast.makeText(DanhSachPlayListActivity.this, "không có bài hát nào trong play list", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //Xử lý xoá playlist
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DanhSachPlayListActivity.this);
                builder.setMessage("Bạn có muốn xóa play list này không");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       int k = userController.XoaPlayPlist(arrayList.get(position).getId());
                       if(k==0){
                           Toast.makeText(DanhSachPlayListActivity.this, "bạn đang còn bài hát trong playlist !vì vậy không thể xóa !", Toast.LENGTH_SHORT).show();
                       }else{
                           list_play.remove(position);
                           arrayAdapter.notifyDataSetChanged();
                       }
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();

                return true;
            }
        });





    }
//Hiển thị Dialog thêm paylist
    private void ShowDiaLogAdd(UserController userController) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_tao);
        dialog.show();
        EditText editao = dialog.findViewById(R.id.editName);
        dialog.findViewById(R.id.btntao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tao = editao.getText().toString().trim();
                if(tao.length()>0){
                    userController.TaoPlayListNhac(tao);
                    list_play.add(tao);
                    arrayAdapter.notifyDataSetChanged();
                    dialog.cancel();
                }else{
                    Toast.makeText(DanhSachPlayListActivity.this, "Tên không để trống", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
    }
//Hiển thị DiaLog Delete
    private void ShowDiaLogDelete(int direction) {

        BaiHatController baiHatController = new BaiHatController();
        AlertDialog.Builder alert =new AlertDialog.Builder(this);
        alert.setTitle("Thông báo ");
        alert.setMessage("Bạn có muốn bỏ thích bài hát này ?");
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                baiHatController.XoaYeuThich(arrayList.get(direction).getId());
                arrayList.remove(direction);
                adapter.notifyDataSetChanged();

            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                adapter.notifyDataSetChanged();
            }
        });
        adapter.notifyDataSetChanged();
        alert.show();
    }
}
