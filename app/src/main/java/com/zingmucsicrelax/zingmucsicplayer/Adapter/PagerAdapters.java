package com.zingmucsicrelax.zingmucsicplayer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.squareup.picasso.Picasso;
import com.zingmucsicrelax.zingmucsicplayer.R;

import java.util.ArrayList;

public class PagerAdapters  extends PagerAdapter {
    private Context context;
    private ArrayList<String> arrayList;

    public PagerAdapters(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
       View view = LayoutInflater.from(context).inflate(R.layout.dong_banner,null);
        ImageView hinhanh = view.findViewById(R.id.hinhanh);

        Picasso.with(context).load(arrayList.get(position)).into(hinhanh);



        container.addView(view);


        return  view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
