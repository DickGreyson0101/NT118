package com.zingmucsicrelax.zingmucsicplayer.Controller;

import com.zingmucsicrelax.zingmucsicplayer.Model.BaiHat;
import com.zingmucsicrelax.zingmucsicplayer.Model.Playlist;

import java.util.ArrayList;

public class BaiHatController {
    private BaiHat baiHat;

    public BaiHatController(){
        baiHat = new BaiHat();
    }
    public ArrayList<BaiHat> getDataListBH(){
        return  baiHat.getDataListBaiHat();
    }
    public ArrayList<String> getDataListBanner(){
        return  baiHat.getDataListBanner();
    }
    public  ArrayList<BaiHat> getDataListBaiHatYeuThich(int iduser){
        return  baiHat.getDataListBaiHatYeuThich(iduser);
    }

    public void XoaYeuThich(int id) {
        baiHat.XoaYeuThichBH(id);
    }

    public ArrayList<Playlist> getDataPlayList(int iduser) {

        return  baiHat.getDataPlayList(iduser);
    }


    public ArrayList<BaiHat> getDataListBaiHatPlayList(int userID, int id) {
        return  baiHat.getDataListBaiHatPlayList(userID,id);
    }

    public void XoaPlayList(int id) {
        baiHat.XoaPlayList(id);
    }

    public ArrayList<BaiHat> getDataListByHatSearch(String name) {
        return  baiHat.getDataListBaiHatSearch(name);
    }
}
