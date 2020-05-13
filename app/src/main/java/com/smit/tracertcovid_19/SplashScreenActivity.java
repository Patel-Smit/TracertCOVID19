package com.smit.tracertcovid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    //Variables
    Animation topAnimation,bottomAnimation;
    ImageView logo;
    TextView appName, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        //Animations
        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //Hooks
        logo = findViewById(R.id.iv_logo);
        appName = findViewById(R.id.tv_appName);
        slogan = findViewById(R.id.tv_slogan);

        //Set animation to elements
        logo.setAnimation(topAnimation);
        appName.setAnimation(bottomAnimation);
        slogan.setAnimation(bottomAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                //Pair[] pairs = new Pair[2];
                //pairs[0] = new Pair<View,String>(logo, "tr_logo_image");
                //pairs[1] = new Pair<View,String>(appName, "tr_logo_text");
                //ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreenActivity.this,pairs);
                //startActivity(i,options.toBundle());
                startActivity(i);
            }
        }, 3000);
    }
}
