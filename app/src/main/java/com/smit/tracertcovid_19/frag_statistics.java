package com.smit.tracertcovid_19;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.EventListener;

public class frag_statistics extends Fragment {


    private DatabaseReference mDatabaseReference;
    TextView tested, totalCases, deaths, lastupdated;
    ImageView imageMap,epidemicCurve,individualTested;
    //String imageMapURl = "https://cdn.shoplightspeed.com/shops/611783/files/16571311/image.jpg";
    //String epidemicCurveURl = "https://httpsimage.com/v2/dd3637a0-c5e4-4c4a-9659-31b0e9fc7bac.jpg";
    //String individualTestedURl = "https://www.smitpatel.tech/TracertCOVID19/individualTested.PNG";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_statistics,container,false);
        imageMap = (ImageView)v.findViewById(R.id.iv_map);
        epidemicCurve = (ImageView)v.findViewById(R.id.iv_graph);
        individualTested = (ImageView)v.findViewById(R.id.iv_tested);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("dataStats");
        tested = (TextView) v.findViewById(R.id.tv_tested);
        totalCases = (TextView) v.findViewById(R.id.tv_totalCases);
        deaths = (TextView) v.findViewById(R.id.tv_deaths);
        lastupdated = (TextView) v.findViewById(R.id.tv_lastupdate);

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String strtested = dataSnapshot.child("tested").getValue().toString();
                tested.setText(strtested);
                String strtotalcases = dataSnapshot.child("totalCases").getValue().toString();
                totalCases.setText(strtotalcases);
                String strdeaths = dataSnapshot.child("deaths").getValue().toString();
                deaths.setText(strdeaths);
                String imgmapurl = dataSnapshot.child("imagemapurl").getValue().toString();
                Picasso.get().load(imgmapurl).into(imageMap);
                String imgcurveurl = dataSnapshot.child("imagecurveurl").getValue().toString();
                Picasso.get().load(imgcurveurl).into(epidemicCurve);
                String imgtestedurl = dataSnapshot.child("imagetestedurl").getValue().toString();
                Picasso.get().load(imgtestedurl).into(individualTested);
                String lstupdate = dataSnapshot.child("lastupdated").getValue().toString();
                lastupdated.setText(lstupdate);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //Picasso.get().load(imageMapURl).into(imageMap);
        //Picasso.get().load(epidemicCurveURl).into(epidemicCurve);
        //Picasso.get().load(individualTestedURl).into(individualTested);

        return v;
    }

}
