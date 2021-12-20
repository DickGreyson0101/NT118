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

public class DangKyActivity extends AppCompatActivity
 implements  View.OnClickListener{

    private EditText editUsername,editpass,editrepass;
    private Button btndangnhap;
    private TextView txtdangky;
    private UserController userController;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        editpass=findViewById(R.id.editmatkhau);
        editrepass=findViewById(R.id.editrepass);
        editUsername=findViewById(R.id.editTenDangNhap);
        btndangnhap = findViewById(R.id.btndangnhap);
        txtdangky = findViewById(R.id.txtdangky);

        userController = new UserController(this);

        txtdangky.setOnClickListener(this);
        btndangnhap.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btndangnhap:
                String username=editUsername.getText().toString().trim();
                String pass=editpass.getText().toString().trim();
                String pass1=editrepass.getText().toString().trim();
                userController.DangKy(username,pass,pass1);break;
            case R.id.txtdangky:
                startActivity(new Intent( DangKyActivity.this,DangNhapActivity.class));break;


        }
    }
}
