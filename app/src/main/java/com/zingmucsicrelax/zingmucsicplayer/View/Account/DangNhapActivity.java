package com.zingmucsicrelax.zingmucsicplayer.View.Account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zingmucsicrelax.zingmucsicplayer.Controller.UserController;
import com.zingmucsicrelax.zingmucsicplayer.R;
import com.zingmucsicrelax.zingmucsicplayer.View.HomeActivity;

public class DangNhapActivity  extends AppCompatActivity
 implements  View.OnClickListener{

    private EditText editUsername,editpass;
    private Button btndangnhap;
    private TextView txtdangky,txtboqua;
    private UserController userController;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        editpass=findViewById(R.id.editmatkhau);
        editUsername=findViewById(R.id.editTenDangNhap);
        btndangnhap = findViewById(R.id.btndangnhap);
        txtdangky = findViewById(R.id.txtdangky);
        txtboqua = findViewById(R.id.txtboqua);

        userController = new UserController(this);

        txtdangky.setOnClickListener(this);
        btndangnhap.setOnClickListener(this);
        txtboqua.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btndangnhap:
                String username=editUsername.getText().toString().trim();
                String pass=editpass.getText().toString().trim();
                userController.DangNhap(username,pass);break;
            case R.id.txtdangky: startActivity(new Intent( DangNhapActivity.this,DangKyActivity.class));break;
            case R.id.txtboqua: startActivity(new Intent( DangNhapActivity.this, HomeActivity.class));break;

        }
    }
}
