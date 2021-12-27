package com.zingmucsicrelax.zingmucsicplayer.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.zingmucsicrelax.zingmucsicplayer.Controller.SetOnItemClick;
import com.zingmucsicrelax.zingmucsicplayer.Model.BaiHat;
import com.zingmucsicrelax.zingmucsicplayer.R;
import com.zingmucsicrelax.zingmucsicplayer.View.Player.PlayMusicActivity;

import java.util.ArrayList;

public class DanhSachBaiHatMoiAdapter  extends RecyclerView.Adapter<DanhSachBaiHatMoiAdapter.ViewHodler> {
    private ArrayList<BaiHat> arrayList;
    private Context context;

    public DanhSachBaiHatMoiAdapter(ArrayList<BaiHat> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public DanhSachBaiHatMoiAdapter.ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dong_baihat,parent,false);
        return new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhSachBaiHatMoiAdapter.ViewHodler holder, int position) {

        Picasso.with(context).load(arrayList.get(position).getHinhanh()).into(holder.hinhanh);
        holder.txttencasi.setText(arrayList.get(position).getTencasi());
        holder.txttenbaihat.setText(arrayList.get(position).getTenbaihat());
        int theloaiid = arrayList.get(position).getTheloai();
        String tentheloai = "";
        switch (theloaiid)
        {
            case 1:
            {
                tentheloai = "Nhạc trẻ";
                break;
            }
            case 2:
            {
                tentheloai = "Trữ tình";
                break;
            }
            case 3:
            {
                tentheloai = "Kinh dị";
                break;
            }
            case 4:
            {
                tentheloai = "Thiếu nhi";
                break;
            }
            default:
                tentheloai = "Chưa xác định";
                break;
        }
        holder.txttheloai.setText(tentheloai);
        holder.SetOnItemClick(new SetOnItemClick() {
            @Override
            public void SetOnItemClickListener(View view, int pos) {
                Intent intent = new Intent(context, PlayMusicActivity.class);
                intent.putExtra("BH",arrayList.get(pos));
                intent.putExtra("type",4);
                context.startActivity(intent);

            }
        });




    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder implements  View.OnClickListener{
        TextView txttencasi,txttenbaihat,txttheloai;
        SetOnItemClick setOnItemClick;
        ImageView hinhanh;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            txttenbaihat = itemView.findViewById(R.id.txttenbaihat);
            txttencasi=itemView.findViewById(R.id.txtencasi);
            hinhanh=itemView.findViewById(R.id.hinhanh);
            txttheloai=itemView.findViewById(R.id.txttheloai);
            itemView.setOnClickListener(this::onClick);
        }
        public  void  SetOnItemClick(SetOnItemClick itemClick){
            this.setOnItemClick = itemClick;
        }

        @Override
        public void onClick(View v) {
            setOnItemClick.SetOnItemClickListener(v,getAdapterPosition());
        }
    }
}
