package com.zingmucsicrelax.zingmucsicplayer.Model;

import android.content.Context;
import android.util.Log;

import com.zingmucsicrelax.zingmucsicplayer.DAO.DB;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BaiHat implements Serializable {
    private  int id;
    private  int id_playlist;
    private  String tenbaihat;
    private  String hinhanh;
    private  String tencasi;
    private  String url_baihat;
    private  int theloai;
    private  String loibaihat;
    private Connection connection;



    public BaiHat(int id, String tenbaihat, String hinhanh, String tencasi, String url_baihat, int theloai, String loibaihat) {
        this.id = id;
        this.tenbaihat = tenbaihat;
        this.hinhanh = hinhanh;
        this.tencasi = tencasi;
        this.url_baihat = url_baihat;
        this.theloai = theloai;
        this.loibaihat = loibaihat;
    }
public BaiHat(int id, int id_playlist, String tenbaihat, String hinhanh, String tencasi, String url_baihat, int theloai, String loibaihat) {
        this.id = id;
    this.id_playlist = id_playlist;
        this.tenbaihat = tenbaihat;
        this.hinhanh = hinhanh;
        this.tencasi = tencasi;
        this.url_baihat = url_baihat;
        this.theloai = theloai;
        this.loibaihat = loibaihat;

    }

    public int getId_playlist() {
        return id_playlist;
    }

    public  BaiHat() {
       connection = DB.getConnection();
    }
    public ArrayList<BaiHat> getDataListBaiHat(){

        ArrayList<BaiHat> arrayList = new ArrayList<>();
        String SQL="SELECT * FROM baihat";
        try {
            Statement sm = connection.createStatement();
            ResultSet rs = sm.executeQuery(SQL);
            while (rs.next()){
                arrayList.add(new BaiHat(rs.getInt("id"),rs.getString("tenbaihat"),
                        rs.getString("hinhanh"),
                        rs.getString("tencasi"),
                        rs.getString("url_baihat"),
                        rs.getInt("id_theloai"),
                        rs.getString("loibaihat")));
            }
        } catch (SQLException throwables) {
            Log.d("CHECKED",throwables.getMessage());
        }


        return  arrayList;

    }
    public ArrayList<BaiHat> getDataListBaiHatYeuThich(int iduser){

        ArrayList<BaiHat> arrayList = new ArrayList<>();
        String SQL="SELECT baihatyeuthich.id,baihat.tenbaihat,baihat.hinhanh,baihat.tencasi," +
                "                baihat.url_baihat,baihat.id_theloai,baihat.loibaihat FROM baihat,baihatyeuthich" +
                "                 WHERE baihat.id= baihatyeuthich.id_baihat AND baihatyeuthich.id_user= '"+iduser+"'";
        try {
            Statement sm = connection.createStatement();
            ResultSet rs = sm.executeQuery(SQL);
            while (rs.next()){
                arrayList.add(new BaiHat(rs.getInt("id"),rs.getString("tenbaihat"),
                        rs.getString("hinhanh"),
                        rs.getString("tencasi"),
                        rs.getString("url_baihat"),
                        rs.getInt("id_theloai"),
                        rs.getString("loibaihat")));
            }
        } catch (SQLException throwables) {
            Log.d("CHECKED",throwables.getMessage());
        }


        return  arrayList;

    }
    public ArrayList<BaiHat> getDataBaihatmoi(){

        ArrayList<BaiHat> arrayList = new ArrayList<>();
        String SQL="SELECT * FROM baihat ORDER BY ngaythem DESC limit 5";
        try {
            Statement sm = connection.createStatement();
            ResultSet rs = sm.executeQuery(SQL);
            while (rs.next()){
                arrayList.add(new BaiHat(rs.getInt("id"),rs.getString("tenbaihat"),
                        rs.getString("hinhanh"),
                        rs.getString("tencasi"),
                        rs.getString("url_baihat"),
                        rs.getInt("id_theloai"),
                        rs.getString("loibaihat")));
            }
        } catch (SQLException throwables) {
            Log.d("CHECKED",throwables.getMessage());
        }


        return  arrayList;

    }
    public ArrayList<String> getDataListBanner(){

        ArrayList<String> arrayList = new ArrayList<>();
        String SQL="SELECT * FROM banner";
        try {
            Statement sm = connection.createStatement();
            ResultSet rs = sm.executeQuery(SQL);
            while (rs.next()){
                arrayList.add(rs.getString("hinhanh"));
            }
        } catch (SQLException throwables) {
            Log.d("CHECKED",throwables.getMessage());
        }


        return  arrayList;

    }
    public  String gettentheloai(int idtheloai){
        String SQL="SELECT * FROM theloai WHERE id = '"+idtheloai+"'";
        Statement sm = null;
        String tentheloai = "";
        try {
            sm = connection.createStatement();
            ResultSet rs = sm.executeQuery(SQL);
            while (rs.next()){
                tentheloai = rs.getString("tentheloai");
            }
        } catch (SQLException throwables) {

        }

        return  tentheloai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenbaihat() {
        return tenbaihat;
    }

    public void setTenbaihat(String tenbaihat) {
        this.tenbaihat = tenbaihat;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getTencasi() {
        return tencasi;
    }

    public void setTencasi(String tencasi) {
        this.tencasi = tencasi;
    }

    public String getUrl_baihat() {
        return url_baihat;
    }

    public void setUrl_baihat(String url_baihat) {
        this.url_baihat = url_baihat;
    }

    public int getTheloai() {
        return theloai;
    }
    public void setTheloai(int theloai) {
        this.theloai = theloai;
    }

    public String getLoibaihat() {
        return loibaihat;
    }

    public void setLoibaihat(String loibaihat) {
        this.loibaihat = loibaihat;
    }

    public void XoaYeuThichBH(int id) {
        String SQL="DELETE FROM baihatyeuthich WHERE id= '"+id+"'";
        try {
            PreparedStatement psm = connection.prepareStatement(SQL);
            psm.execute();
            psm.close();
        } catch (SQLException throwables) {
         Log.d("CHECKED",throwables.getMessage());
        }
    }

    public ArrayList<Playlist> getDataPlayList(int iduser) {
        ArrayList<Playlist> arrayList = new ArrayList<>();
        String SQL="SELECT * FROM playlist WHERE id_user = '"+iduser+"'";
        try {
            Statement sm = connection.createStatement();
            ResultSet rs = sm.executeQuery(SQL);
            while (rs.next()){
                arrayList.add(new Playlist(rs.getInt("id"),rs.getString("tenplaylist")));
            }
        } catch (SQLException throwables) {
            Log.d("CHECKED",throwables.getMessage());
        }


        return  arrayList;
    }

    public ArrayList<BaiHat> getDataListBaiHatPlayList(int userID, int id) {
        ArrayList<BaiHat> arrayList = new ArrayList<>();
        String SQL="SELECT playlist_chitiet.id,playlist_chitiet.id_playlist,baihat.tenbaihat,baihat.hinhanh,baihat.tencasi,\n" +
                "                              baihat.url_baihat,baihat.id_theloai,baihat.loibaihat FROM baihat,playlist_chitiet,playlist\n" +
                "                                WHERE baihat.id= playlist_chitiet.id_baihat AND playlist.id_user= '"+userID+"' " +
                "                AND playlist_chitiet.id_playlist = playlist.id AND playlist_chitiet.id_playlist= '"+id+"'";
        try {
            Statement sm = connection.createStatement();
            ResultSet rs = sm.executeQuery(SQL);
            while (rs.next()){
                arrayList.add(new BaiHat(rs.getInt("id"),rs.getInt("id_playlist"),rs.getString("tenbaihat"),
                        rs.getString("hinhanh"),
                        rs.getString("tencasi"),
                        rs.getString("url_baihat"),
                        rs.getInt("id_theloai"),
                        rs.getString("loibaihat")));
            }
        } catch (SQLException throwables) {
            Log.d("CHECKED",throwables.getMessage());
        }


        return  arrayList;
    }

    public void XoaPlayList(int id) {
        String SQL="DELETE FROM playlist_chitiet WHERE id= '"+id+"'";
        try {
            PreparedStatement psm = connection.prepareStatement(SQL);
            psm.execute();
            psm.close();
        } catch (SQLException throwables) {
            Log.d("CHECKED",throwables.getMessage());
        }
    }

    public ArrayList<BaiHat> getDataListBaiHatSearch(String name) {
        ArrayList<BaiHat> arrayList = new ArrayList<>();
        String SQL="SELECT * FROM baihat WHERE tenbaihat LIKE '%"+name+"%'";
        try {
            Statement sm = connection.createStatement();
            ResultSet rs = sm.executeQuery(SQL);
            while (rs.next()){
                arrayList.add(new BaiHat(rs.getInt("id"),rs.getString("tenbaihat"),
                        rs.getString("hinhanh"),
                        rs.getString("tencasi"),
                        rs.getString("url_baihat"),
                        rs.getInt("id_theloai"),
                        rs.getString("loibaihat")));
            }
        } catch (SQLException throwables) {
            Log.d("CHECKED",throwables.getMessage());
        }
        return  arrayList;

    }
}
