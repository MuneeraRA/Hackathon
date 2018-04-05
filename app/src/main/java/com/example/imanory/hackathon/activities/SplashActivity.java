package com.example.imanory.hackathon.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.imanory.hackathon.R;


public class SplashActivity extends Activity {

    private Intent intent;
    private String token, id, name;
    Thread splashTread;


    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        StartAnimations();
    }

    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        RelativeLayout l = (RelativeLayout) findViewById(R.id.relativelayout);
        l.clearAnimation();
        l.startAnimation(anim);
        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.logo);
        iv.clearAnimation();
        iv.startAnimation(anim);
        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
// Splash screen pause time
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }

                    Intent intent = declareIntent();
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    SplashActivity.this.finish();


                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    SplashActivity.this.finish();
                }
            }
        };

        splashTread.start();
    }


    public Intent declareIntent() {

//        token = SharedPreferencesUtils.getCurrentUserToken(this);
//        id = SharedPreferencesUtils.getCurrentUserId(this);
//        name = SharedPreferencesUtils.getCurrentUsername(this);
//
//        if (token.equals("") && id.equals("") && name.equals(""))
//            intent = new Intent(getApplicationContext(), IntroductionActivity.class);
//        else
        intent = new Intent(getApplicationContext(), Login.class);
        return intent;

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}