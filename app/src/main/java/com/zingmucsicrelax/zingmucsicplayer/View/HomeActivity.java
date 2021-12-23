package com.zingmucsicrelax.zingmucsicplayer.View;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.zingmucsicrelax.zingmucsicplayer.Adapter.DanhSachBaiHatAdapter;
import com.zingmucsicrelax.zingmucsicplayer.Adapter.DanhSachBaiHatMoiAdapter;
import com.zingmucsicrelax.zingmucsicplayer.Adapter.PagerAdapters;
import com.zingmucsicrelax.zingmucsicplayer.Controller.BaiHatController;
import com.zingmucsicrelax.zingmucsicplayer.Model.BaiHat;
import com.zingmucsicrelax.zingmucsicplayer.R;
import com.zingmucsicrelax.zingmucsicplayer.ShareConfig;
import com.zingmucsicrelax.zingmucsicplayer.View.Account.DangKyActivity;
import com.zingmucsicrelax.zingmucsicplayer.View.Account.DangNhapActivity;
import com.zingmucsicrelax.zingmucsicplayer.View.Love.DanhSachBaiHatYeuThichActivity;
import com.zingmucsicrelax.zingmucsicplayer.View.PlayList.DanhSachPlayListActivity;

import java.util.ArrayList;

public class HomeActivity  extends AppCompatActivity {
    private ViewPager viewPager;
    private BaiHatController baiHatController;
    private PagerAdapters pagerAdapter;
    private  int k = 0;
    private DanhSachBaiHatAdapter danhSachBaiHatAdapter;
    private  ArrayList<BaiHat> arrayList_BH, arrayList_BHM;
    private RecyclerView rcvDSBH, rcvDSBHM;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private EditText editSearch;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        InitWidget();
        Init();
    }

    private void Init() {
        Banner();
        arrayList_BH  = baiHatController.getDataListBH();
        DanhSachBaiHatAdapter danhSachBaiHatAdapter = new DanhSachBaiHatAdapter(arrayList_BH,this);
        rcvDSBH.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rcvDSBH.setAdapter(danhSachBaiHatAdapter);

        arrayList_BHM  = baiHatController.getDataBaihatmoi();
        DanhSachBaiHatMoiAdapter danhSachBaiHatMoiAdapter = new DanhSachBaiHatMoiAdapter(arrayList_BHM,this);
        rcvDSBHM.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rcvDSBHM.setAdapter(danhSachBaiHatMoiAdapter);

        ShareConfig shareConfig = new ShareConfig(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        if(shareConfig.getUserID()>0){
            toolbar.setVisibility(View.VISIBLE);
            navigationView.setVisibility(View.VISIBLE);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.Open,
                    R.string.Close);
            toggle.syncState();
        }else{
            ShowDiaLog();
            toolbar.setVisibility(View.GONE);
            navigationView.setVisibility(View.GONE);
        }
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.songlove:
                        startActivity(new Intent(HomeActivity.this, DanhSachBaiHatYeuThichActivity.class));
                        break;
                    case R.id.signout:
                        shareConfig.PutUserID(0);
                        startActivity(new Intent(HomeActivity.this, DangNhapActivity.class));
                        break;

                    case R.id.playlist:
                        startActivity(new Intent(HomeActivity.this, DanhSachPlayListActivity.class));
                        break;
                }
                return true;
            }
        });

        editSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    String text= editSearch.getText().toString().trim();
                    if(text.length()>0){
                        startActivity(new Intent(HomeActivity.this,SearchActivity.class).putExtra("KEY",text));

                    }else{
                        Toast.makeText(HomeActivity.this, "Từ khóa không để trống", Toast.LENGTH_SHORT).show();
                    }
                }
                return true;
            }
        });



    }

    private void ShowDiaLog() {

        Dialog dialog  = new Dialog(this);
        dialog.setContentView(R.layout.dialog_user);
        dialog.show();
       dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
       dialog.findViewById(R.id.btndangnhap).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(HomeActivity.this,DangNhapActivity.class));
               finish();
           }
       });
        dialog.findViewById(R.id.btndangky).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, DangKyActivity.class));
                finish();
            }
        });
        dialog.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

    }

    private void Banner() {
        baiHatController = new BaiHatController();
        ArrayList<String> arrayList = baiHatController.getDataListBanner();

        pagerAdapter = new PagerAdapters(this,arrayList);
        viewPager.setAdapter(pagerAdapter);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                k = viewPager.getCurrentItem();
                if(k>=arrayList.size()-1){
                    k=0;
                }else{
                    k++;

                }
                viewPager.setCurrentItem(k,true);
                handler.postDelayed(this,3000);

            }
        },3000);
    }

    private void InitWidget() {
        viewPager = findViewById(R.id.viewpager);
        rcvDSBH  = findViewById(R.id.recycleDSBH);
        rcvDSBHM  = findViewById(R.id.recycleDSBHM);
        navigationView = findViewById(R.id.navigationview);
        drawerLayout = findViewById(R.id.drawerlayout);
        toolbar = findViewById(R.id.toolbar);
        editSearch = findViewById(R.id.editTimkiem);

    }

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        arrayList_BH  = baiHatController.getDataListBH();
        DanhSachBaiHatAdapter danhSachBaiHatAdapter = new DanhSachBaiHatAdapter(arrayList_BH,this);
        rcvDSBH.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rcvDSBH.setAdapter(danhSachBaiHatAdapter);

        arrayList_BHM  = baiHatController.getDataBaihatmoi();
        DanhSachBaiHatMoiAdapter danhSachBaiHatMoiAdapter = new DanhSachBaiHatMoiAdapter(arrayList_BHM,this);
        rcvDSBHM.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rcvDSBHM.setAdapter(danhSachBaiHatMoiAdapter);
    }
}
