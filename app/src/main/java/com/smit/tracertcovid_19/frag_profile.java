package com.smit.tracertcovid_19;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.firebase.auth.FirebaseAuth;

public class frag_profile extends Fragment {
    Button logoutbtn;
    EditText naame,doob,ciity,emmail,paassword;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.frag_profile,container,false);
        View v = inflater.inflate(R.layout.frag_profile,container,false);
        naame = (EditText) v.findViewById(R.id.p_et_name);
        naame.setText(MainActivity.nname);
        doob = (EditText) v.findViewById(R.id.p_et_DOB);
        doob.setText(MainActivity.ddob);
        ciity = (EditText) v.findViewById(R.id.p_et_city);
        ciity.setText(MainActivity.ccity);
        emmail = (EditText) v.findViewById(R.id.p_et_email);
        emmail.setText(MainActivity.eemail);
        paassword = (EditText) v.findViewById(R.id.p_et_password);
        paassword.setText(MainActivity.ppassword);

        logoutbtn = (Button)v.findViewById(R.id.btn_logout);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity().getApplication(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }
}
