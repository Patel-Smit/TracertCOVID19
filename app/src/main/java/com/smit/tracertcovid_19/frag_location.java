package com.smit.tracertcovid_19;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class frag_location extends Fragment {
    private DatabaseReference mDatabaseReference;
    TextView citytotalcases, citytottaldeaths, area1, area2, area3, area4, area5, area6, cityOverallStats;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_location, container, false);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("datacity");
        citytotalcases = (TextView) v.findViewById(R.id.tv_city_totalCases);
        citytottaldeaths = (TextView) v.findViewById(R.id.tv_city_deaths);
        area1 = (TextView) v.findViewById(R.id.tv_area1);
        area2 = (TextView) v.findViewById(R.id.tv_area2);
        area3 = (TextView) v.findViewById(R.id.tv_area3);
        area4 = (TextView) v.findViewById(R.id.tv_area4);
        area5 = (TextView) v.findViewById(R.id.tv_area5);
        area6 = (TextView) v.findViewById(R.id.tv_area6);
        cityOverallStats = (TextView) v.findViewById(R.id.tv_overallStats);

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String ttlcases = dataSnapshot.child("totalcases").getValue().toString();
                citytotalcases.setText(ttlcases);
                String ttldeaths = dataSnapshot.child("totaldeaths").getValue().toString();
                citytottaldeaths.setText(ttldeaths);
                String area01 = dataSnapshot.child("area1").getValue().toString();
                area1.setText(area01);
                String area02 = dataSnapshot.child("area2").getValue().toString();
                area2.setText(area02);
                String area03 = dataSnapshot.child("area3").getValue().toString();
                area3.setText(area03);
                String area04 = dataSnapshot.child("area4").getValue().toString();
                area4.setText(area04);
                String area05 = dataSnapshot.child("area5").getValue().toString();
                area5.setText(area05);
                String area06 = dataSnapshot.child("area6").getValue().toString();
                area6.setText(area06);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        cityOverallStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(), cityOverallStatsActivity.class);
                startActivity(i);
            }
        });

        return v;
    }
}
