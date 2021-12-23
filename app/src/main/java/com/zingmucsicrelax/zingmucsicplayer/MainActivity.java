package com.zingmucsicrelax.zingmucsicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.zingmucsicrelax.zingmucsicplayer.DAO.DB;
import com.zingmucsicrelax.zingmucsicplayer.View.HomeActivity;

import java.sql.Connection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              startActivity(new Intent( MainActivity.this, HomeActivity.class));
          }
      },2500);
    }
}