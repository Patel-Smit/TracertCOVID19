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
    TextView tested,totalCases,deaths;
    ImageView imageMap,epidemicCurve,individualTested;
    String imageMapURl = "http://www.smitpatel.tech/TracertCOVID19/covidmap.png";
    String epidemicCurveURl = "http://www.smitpatel.tech/TracertCOVID19/graph.png";
    String individualTestedURl = "http://www.smitpatel.tech/TracertCOVID19/individualTested.png";

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

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String strtested = dataSnapshot.child("tested").getValue().toString();
                tested.setText(strtested);
                String strtotalcases = dataSnapshot.child("totalCases").getValue().toString();
                totalCases.setText(strtotalcases);
                String strdeaths = dataSnapshot.child("deaths").getValue().toString();
                deaths.setText(strdeaths);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Picasso.get().load(imageMapURl).into(imageMap);
        Picasso.get().load(epidemicCurveURl).into(epidemicCurve);
        Picasso.get().load(individualTestedURl).into(individualTested);

        return v;
    }

}
