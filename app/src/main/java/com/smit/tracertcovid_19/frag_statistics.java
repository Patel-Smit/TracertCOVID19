package com.smit.tracertcovid_19;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

public class frag_statistics extends Fragment {

    ImageView imageMap;
    String imageMapURl = "https://replicationindex.files.wordpress.com/2020/03/image-19.png?w=1024";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_statistics,container,false);
        imageMap = (ImageView)v.findViewById(R.id.iv_map);
        Picasso.get().load(imageMapURl).into(imageMap);
        return v;
    }
}
