package com.zingmucsicrelax.zingmucsicplayer.View.Player;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.zingmucsicrelax.zingmucsicplayer.Adapter.ViewPagerAdapter;
import com.zingmucsicrelax.zingmucsicplayer.Model.BaiHat;
import com.zingmucsicrelax.zingmucsicplayer.R;
import com.zingmucsicrelax.zingmucsicplayer.View.FragMent.FragMent_Lyrics;
import com.zingmucsicrelax.zingmucsicplayer.View.FragMent.FragMent_Player;

import me.relex.circleindicator.CircleIndicator;

public class PlayMusicActivity extends AppCompatActivity {
    public static BaiHat baiHat;
    private Intent intent;
    private MediaPlayer mediaPlayer;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    public  static   int type = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        InitWidget();
        Init();
    }

    private void Init() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        intent=getIntent();
        baiHat = (BaiHat) intent.getSerializableExtra("BH");
        type = intent.getIntExtra("type",0);
        viewPagerAdapter =new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.AddFragMent(new FragMent_Lyrics());
        viewPagerAdapter.AddFragMent(new FragMent_Player());
        viewPager.setAdapter(viewPagerAdapter);
        circleIndicator.setViewPager(viewPager);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                viewPager.setCurrentItem(1,true);
            }
        },200);





    }

    private void InitWidget() {
        viewPager = findViewById(R.id.viewpager);
        circleIndicator = findViewById(R.id.circleSelect);
    }
}
