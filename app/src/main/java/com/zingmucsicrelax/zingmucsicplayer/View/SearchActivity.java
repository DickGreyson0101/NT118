package com.zingmucsicrelax.zingmucsicplayer.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zingmucsicrelax.zingmucsicplayer.Adapter.DanhSachSearchBaiHatAdapter;
import com.zingmucsicrelax.zingmucsicplayer.Controller.BaiHatController;
import com.zingmucsicrelax.zingmucsicplayer.Model.BaiHat;
import com.zingmucsicrelax.zingmucsicplayer.R;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView lv;
    private DanhSachSearchBaiHatAdapter adapter;
    private BaiHatController baiHatController;
    private ArrayList<BaiHat> arrayList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acvitiy_search);
        lv=findViewById(R.id.lv);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent= getIntent();
        String name= intent.getStringExtra("KEY");
        baiHatController =new BaiHatController();

        arrayList = baiHatController.getDataListByHatSearch(name);

        adapter = new DanhSachSearchBaiHatAdapter(arrayList,this);
        lv.setLayoutManager(new LinearLayoutManager(this));
        lv.setAdapter(adapter);


        getSupportActionBar().setTitle(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
