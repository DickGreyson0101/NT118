package com.zingmucsicrelax.zingmucsicplayer.Controller;

import android.content.Context;

import com.zingmucsicrelax.zingmucsicplayer.Model.Playlist;
import com.zingmucsicrelax.zingmucsicplayer.Model.User;
import com.zingmucsicrelax.zingmucsicplayer.ShareConfig;

public class UserController {
    private User user;
    private  Context context;
    private Playlist playlist;

    public  UserController(Context context){
        this.context= context;
        user =new User(context);
        playlist = new Playlist(context);

    }
    public  void DangNhap(String username,String pass){
        user.DangNhapTK(username,pass);
    }
    public  void DangKy(String username,String pass,String repass){
        user.DangKyTK(username,pass,repass);
    }
    public  int  TaoPlayListNhac(String name){
       return  playlist.TaoPlayList(name);
    }
    public  void ThemMucBaiHatYeuThich(int id,int userid){
        user.ThemBaiHatyeuThich(id,userid);
    }

    public void ThembaiHatVaoPlayList(int id, int id_baihat) {
        playlist.ThemBaiHatVaoMucYeuThich(id,id_baihat);
    }

    public int  XoaPlayPlist(int id) {
      return   playlist.XoaPlayList(id);
    }
}
