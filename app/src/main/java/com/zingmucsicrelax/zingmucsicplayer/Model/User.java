package com.zingmucsicrelax.zingmucsicplayer.Model;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.zingmucsicrelax.zingmucsicplayer.DAO.DB;
import com.zingmucsicrelax.zingmucsicplayer.ShareConfig;
import com.zingmucsicrelax.zingmucsicplayer.View.Account.DangNhapActivity;
import com.zingmucsicrelax.zingmucsicplayer.View.HomeActivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
    private  String username;
    private  String pass;
    private Context context;
    private Connection connection;
    public User(Context context){
        this.context= context;
        connection = DB.getConnection();

    }
    public  int Checkbaihatyeuthich(int id_bh,int userid){
        String SQL ="SELECT * FROM baihatyeuthich WHERE id_baihat = '"+id_bh+"' AND id_user='"+userid+"'";
        int check_bh  = 0;
        try {
            Statement sm = connection.createStatement();
            ResultSet rs = sm.executeQuery(SQL);
            while(rs.next()){
                check_bh = rs.getInt("id");
            }
            if(check_bh >0){
                return  1;
            }
        } catch (SQLException throwables) {

        }
        return  0 ;
    }
    public  void ThemBaiHatyeuThich(int id_baihat,int userid){
        ShareConfig shareConfig  = new ShareConfig(context);
        if(Checkbaihatyeuthich(id_baihat,userid)==0){
            String SQL="INSERT INTO baihatyeuthich(id_user,id_baihat) VALUES('"+shareConfig.getUserID()+"','"+id_baihat+"')";
            try {
                PreparedStatement preparedStatement =connection.prepareStatement(SQL);
                preparedStatement.execute();
                preparedStatement.close();
                Toast.makeText(context, "Đã thêm vào mục yêu thích ", Toast.LENGTH_SHORT).show();
            } catch (SQLException throwables) {
                Toast.makeText(context, "Lỗi "+throwables.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(context, "Bạn đã thích bài hát này rồi !", Toast.LENGTH_SHORT).show();
        }

    }
    public  void DangKyTK(String username,String pass,String repass){

        if(username.length()>0){
            if(pass.length()>0){

                if(pass.equals(repass)){

                    if(checkedUserName(username)){
                        try {
                            PreparedStatement psm = connection.prepareStatement("INSERT INTO taikhoan(tentaikhoan,matkhau) VALUES('"+username+"','"+pass+"')");
                            psm.execute();
                            psm.close();
                            Toast.makeText(context,"Đăng ký thành công",Toast.LENGTH_SHORT).show();
                            context.startActivity(new Intent(context, DangNhapActivity.class));
                        } catch (SQLException throwables) {
                            Toast.makeText(context,"Đăng ký thất bại",Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(context,"Tài khoản đã được đăng ký",Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(context,"Mật khẩu không khớp",Toast.LENGTH_SHORT).show();
                }

            }else{
                Toast.makeText(context,"Mật khẩu không để trống",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(context,"tên đăng nhập không để trống",Toast.LENGTH_SHORT).show();
        }

    }
    public  boolean checkedUserName(String username){
        String SQL="SELECT * FROM taikhoan WHERE tentaikhoan = '"+username+"'";
        Statement sm = null;
        int check_iduser = 0 ;
        try {
            sm = connection.createStatement();
            ResultSet rs = sm.executeQuery(SQL);
            while (rs.next()){
                check_iduser = rs.getInt("id");
            }
            if(check_iduser >0){
                return  false;
            }
        } catch (SQLException throwables) {

        }

        return  true;
    }
    public  void DangNhapTK(String username,String pass){
        ShareConfig shareConfig = new ShareConfig(context);
        int check_iduser= 0;
        if(username.length()>0){
            if(pass.length()>0){
                String SQL="SELECT * FROM taikhoan WHERE tentaikhoan = '"+username+"' AND matkhau = '"+pass+"'";
                try {
                    Statement sm = connection.createStatement();
                    ResultSet rs = sm.executeQuery(SQL);
                    while (rs.next()){
                        check_iduser = rs.getInt("id");
                    }
                    if(check_iduser>0){
                        shareConfig.PutUserID(check_iduser);
                        context.startActivity(new Intent( context, HomeActivity.class));
                    }else {
                        Toast.makeText(context,"Sai tài khoản/ Mật khẩu",Toast.LENGTH_SHORT).show();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }else{
                Toast.makeText(context,"Mật khẩu không để trống",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(context,"tên đăng nhập không để trống",Toast.LENGTH_SHORT).show();
        }
    }
}
