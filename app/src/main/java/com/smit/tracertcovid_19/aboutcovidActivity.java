package com.smit.tracertcovid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class aboutcovidActivity extends AppCompatActivity {
TextView aboutCOVID1,aboutCOVID2,aboutCOVID3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutcovid);
        aboutCOVID1 = findViewById(R.id.tv_aboutcovid_1);
        aboutCOVID2 = findViewById(R.id.tv_aboutcovid_2);
        aboutCOVID3 = findViewById(R.id.tv_aboutcovid_3);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            aboutCOVID1.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
            aboutCOVID2.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
            aboutCOVID3.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
        }
    }
}
