package com.smit.tracertcovid_19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    //Button logoutbtn;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private DatabaseReference mDatabaseReference;
    public static String nname;
    public static String ddob;
    public static String ccity;
    public static String eemail;
    public static String ppassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment selectedFragment = new frag_location();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer,
                selectedFragment).commit();

        Intent intent = getIntent();
        final String userid = intent.getStringExtra("userID");
        System.out.println(userid);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("users");
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (userid==null) {
                    System.out.println("User UUID not valid");
                } else {
                    nname = dataSnapshot.child(userid).child("name").getValue().toString();
                    ddob = dataSnapshot.child(userid).child("dob").getValue().toString();
                    ccity = dataSnapshot.child(userid).child("city").getValue().toString();
                    eemail = dataSnapshot.child(userid).child("email").getValue().toString();
                    ppassword = dataSnapshot.child(userid).child("password").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        //logoutbtn = findViewById(R.id.btn_logout);
        //logoutbtn.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view) {
                //FirebaseAuth.getInstance().signOut();
                //Intent toLogin = new Intent(MainActivity.this,LoginActivity.class);
                //startActivity(toLogin);
            //}
        //});
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.navLocation:
                            selectedFragment = new frag_location();
                            break;
                        case R.id.navResource:
                            selectedFragment = new frag_resources();
                            break;
                        case R.id.navStatistics:
                            selectedFragment = new frag_statistics();
                            break;
                        case R.id.navUpdates:
                            selectedFragment = new frag_updates();
                            break;
                        case R.id.navProfile:
                            selectedFragment = new frag_profile();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                            selectedFragment).commit();

                    return true;
                }
            };
}
