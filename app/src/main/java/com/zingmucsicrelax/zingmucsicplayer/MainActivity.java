package com.zingmucsicrelax.zingmucsicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

//import com.zingmucsicrelax.zingmucsicplayer.View.HomeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              //startActivity(new Intent( MainActivity.this, HomeActivity.class));
          }
      },2500);
    }
}