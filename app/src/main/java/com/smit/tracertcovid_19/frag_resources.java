package com.smit.tracertcovid_19;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;

public class frag_resources extends Fragment {
    LinearLayout aboutCovid, contactUS, selfCheck ,bookAppointment;
    //private DatabaseReference mDatabaseReference;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_resources, container, false);
        aboutCovid = (LinearLayout) v.findViewById(R.id.ll_aboutcovid);
        contactUS = (LinearLayout) v.findViewById(R.id.ll_contactus);
        selfCheck = (LinearLayout) v.findViewById(R.id.ll_selfCheck);
        bookAppointment = (LinearLayout) v.findViewById(R.id.ll_bookAppointment);

        aboutCovid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(),aboutcovidActivity.class);
                startActivity(i);
            }
        });
        contactUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openContactDialog();
            }
        });
        selfCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(),selfcheckActivity.class);
                startActivity(i);
            }
        });
        bookAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBookAppointmentDialog();
            }
        });

        return v;
    }

    public void openContactDialog(){
        contactusDialog contactDialog = new contactusDialog();
        contactDialog.show(getActivity().getSupportFragmentManager(), "Contact Dialog");
    }
    public void openBookAppointmentDialog(){
        bookapointmentDialog appointmentDialog = new bookapointmentDialog();
        appointmentDialog.show(getActivity().getSupportFragmentManager(), "Book Appointment Dialog");
    }
}
