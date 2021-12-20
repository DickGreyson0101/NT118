package com.zingmucsicrelax.zingmucsicplayer.Model;

import android.content.Context;
import android.widget.Toast;

import com.zingmucsicrelax.zingmucsicplayer.DAO.DB;
import com.zingmucsicrelax.zingmucsicplayer.ShareConfig;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Playlist  implements Serializable {
    private  int id;
    private  String tenplaylist;
    private Connection db;
    private ShareConfig shareConfig;
    private  Context context;
    private  Connection connection;

    public  Playlist(Context context){
        this.context=context;
        connection = DB.getConnection();
        shareConfig = new ShareConfig(context);
    }
    public  int  TaoPlayList(String name){
        String SQL="INSERT INTO playlist(id_user,tenplaylist) VALUES('"+shareConfig.getUserID()+"','"+name+"')";
        try {
            PreparedStatement psm= connection.prepareStatement(SQL);
            psm.execute();
            psm.close();
            return  1;

        } catch (SQLException throwables) {
           return  0;
        }

    }

    public Playlist(int id, String tenplaylist) {
        this.id = id;
        this.tenplaylist = tenplaylist;
    }

    public int getId() {
        return id;
    }

    public String getTenplaylist() {
        return tenplaylist;
    }
    public int   checkIDBaiHat(int id_baihat ,int id){
        String SQL="SELECT  * FROM playlist_chitiet WHERE id_baihat ='"+id_baihat+"' AND id_playlist = '"+id+"'";
        int check = 0;
        try {
            Statement sm = connection.createStatement();
            ResultSet rs = sm.executeQuery(SQL);
            while (rs.next()){
                check = rs.getInt("id");
            }
            if(check >0){
                return  1;
            }else{
                return  0;
            }
        } catch (SQLException throwables) {

        }
        return  0;
    }

    public void ThemBaiHatVaoMucYeuThich(int id, int id_baihat) {
        String SQL="INSERT INTO playlist_chitiet(id_playlist,id_baihat) VALUES('"+id+"','"+id_baihat+"')";
        try {
            if(checkIDBaiHat(id_baihat,id)==0){
                PreparedStatement psm= connection.prepareStatement(SQL);
                psm.execute();
                psm.close();
                Toast.makeText(context, "Đã thêm vào playlist", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "Bài hát đã được thêm vào playlist", Toast.LENGTH_SHORT).show();
            }


        } catch (SQLException throwables) {

        }
    }

    public int  XoaPlayList(int id) {
        String SQL="DELETE FROM  playlist WHERE id= '"+id+"'";
        try {
            PreparedStatement psm= connection.prepareStatement(SQL);
            psm.execute();
            psm.close();

            return  1;


        } catch (SQLException throwables) {
          return  0 ;
        }
    }
}
