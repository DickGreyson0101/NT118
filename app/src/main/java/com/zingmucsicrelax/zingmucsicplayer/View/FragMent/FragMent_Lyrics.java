package com.zingmucsicrelax.zingmucsicplayer.View.FragMent;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zingmucsicrelax.zingmucsicplayer.R;
import com.zingmucsicrelax.zingmucsicplayer.View.Player.PlayMusicActivity;

public class FragMent_Lyrics extends Fragment {
    View view;
    public  static  TextView txtlyrics;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lyrics,container,false);
         txtlyrics= view.findViewById(R.id.txtlyrics);
         txtlyrics.setMovementMethod(new ScrollingMovementMethod());
         txtlyrics.setText(PlayMusicActivity.baiHat.getLoibaihat());
        return  view;
    }
}
