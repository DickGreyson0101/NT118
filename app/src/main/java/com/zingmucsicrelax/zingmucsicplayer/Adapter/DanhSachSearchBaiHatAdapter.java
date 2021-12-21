package com.zingmucsicrelax.zingmucsicplayer.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.zingmucsicrelax.zingmucsicplayer.Controller.SetOnItemClick;
import com.zingmucsicrelax.zingmucsicplayer.Model.BaiHat;
import com.zingmucsicrelax.zingmucsicplayer.R;
import com.zingmucsicrelax.zingmucsicplayer.View.Player.PlayMusicActivity;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class DanhSachSearchBaiHatAdapter extends RecyclerView.Adapter<DanhSachSearchBaiHatAdapter.ViewHodler> {
    private ArrayList<BaiHat> arrayList;
    private Context context;

    public DanhSachSearchBaiHatAdapter(ArrayList<BaiHat> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public DanhSachSearchBaiHatAdapter.ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dong_baihat_yeuthich,parent,false);
        return new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhSachSearchBaiHatAdapter.ViewHodler holder, int position) {

        Picasso.with(context).load(arrayList.get(position).getHinhanh()).into(holder.hinhanh);
        holder.txttencasi.setText(arrayList.get(position).getTencasi());
        holder.txttenbaihat.setText(arrayList.get(position).getTenbaihat());
        holder.SetOnItemClick(new SetOnItemClick() {
            @Override
            public void SetOnItemClickListener(View view, int pos) {
                Intent intent = new Intent(context, PlayMusicActivity.class);
                intent.putExtra("BH",arrayList.get(pos));
                context.startActivity(intent);

            }
        });




    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder implements  View.OnClickListener{
        TextView txttencasi,txttenbaihat;
        SetOnItemClick setOnItemClick;
        CircleImageView hinhanh;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            txttenbaihat = itemView.findViewById(R.id.txttenbaihat);
            txttencasi=itemView.findViewById(R.id.txtencasi);
            hinhanh=itemView.findViewById(R.id.hinhanh);
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
