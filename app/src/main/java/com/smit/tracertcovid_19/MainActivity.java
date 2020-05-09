package com.smit.tracertcovid_19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
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
