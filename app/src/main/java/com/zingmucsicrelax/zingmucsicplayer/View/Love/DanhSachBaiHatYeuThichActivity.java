package com.zingmucsicrelax.zingmucsicplayer.View.Love;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

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
import com.zingmucsicrelax.zingmucsicplayer.Model.BaiHat;
import com.zingmucsicrelax.zingmucsicplayer.R;
import com.zingmucsicrelax.zingmucsicplayer.ShareConfig;

import java.util.ArrayList;

public class DanhSachBaiHatYeuThichActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView lv;
    private DanhSachBaiHatYeuThichAdapter adapter;
    private ArrayAdapter arrayAdapter;
    private BaiHatController baiHatController;
    private  ArrayList<BaiHat> arrayList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_bh);
        lv=findViewById(R.id.lv);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("bài hát yêu thích");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        baiHatController = new BaiHatController();
        ShareConfig shareConfig = new ShareConfig(this);
        arrayList = baiHatController.getDataListBaiHatYeuThich(shareConfig.getUserID());
        adapter = new DanhSachBaiHatYeuThichAdapter(arrayList,this);
        lv.setLayoutManager(new LinearLayoutManager(this));
        lv.setAdapter(adapter);


        ItemTouchHelper.SimpleCallback touchCallback =new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                ShowDiaLogDelete(viewHolder.getAdapterPosition());

            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(touchCallback);
        itemTouchHelper.attachToRecyclerView(lv);



    }

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
