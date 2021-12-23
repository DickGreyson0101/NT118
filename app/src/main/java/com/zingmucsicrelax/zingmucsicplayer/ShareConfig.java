package com.zingmucsicrelax.zingmucsicplayer;

import android.content.Context;
import android.content.SharedPreferences;

public class ShareConfig {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public  ShareConfig(Context context){
        sharedPreferences= context.getSharedPreferences("INFO",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public  void PutUserID(int userId){
        editor.putInt("ID",userId);
        editor.commit();
    }
    public  int getUserID(){
        return  sharedPreferences.getInt("ID",0);
    }
}
