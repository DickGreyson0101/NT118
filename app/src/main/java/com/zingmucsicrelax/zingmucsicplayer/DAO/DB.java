package com.zingmucsicrelax.zingmucsicplayer.DAO;

import android.os.StrictMode;
import android.util.Log;

import org.gjt.mm.mysql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    public  static Connection getConnection(){
       Connection connection =null;
       String Url="jdbc:mysql://192.168.1.7/ZingMusicPlayer";
       String username="root";
       String password="123456789";

        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(threadPolicy);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(Url,username,password);
            Log.d("CHECKED","Sucess");
        } catch (SQLException throwables) {
            Log.d("CHECKED",throwables.getMessage()+" ");
        } catch (ClassNotFoundException e) {
            Log.d("CHECKED",e.getMessage()+" ");
        }


        return  connection;

    }
}
