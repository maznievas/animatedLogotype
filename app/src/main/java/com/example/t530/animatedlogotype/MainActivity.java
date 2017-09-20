package com.example.t530.animatedlogotype;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView l_1;
    ImageView l_2;
    ImageView clouds1;
    ImageView clouds2;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l_1 = (ImageView) findViewById(R.id.l_1);
        l_2 = (ImageView) findViewById(R.id.l_2);
        relativeLayout = (RelativeLayout) findViewById(R.id.LLayout);

        l_1.setOnClickListener(this);
        l_2.setOnClickListener(this);
    }

    public void startAnimation3()
    {
        clouds1 = (ImageView) findViewById(R.id.clouds_1_line);
        clouds2 = (ImageView) findViewById(R.id.clouds_2_line);

        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        int displayWidth = metrics.widthPixels;

      // rotate for 45 degreese

        final RotateAnimation animRotate45 = new RotateAnimation(0.0f, 45.0f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
            animRotate45.setDuration(2000);
            animRotate45.setFillAfter(true);
            animRotate45.setFillEnabled(true);

        AnimationSet setRotate45 = new AnimationSet(true);
        setRotate45.setInterpolator(new DecelerateInterpolator());
        setRotate45.setFillAfter(true);
        setRotate45.setFillEnabled(true);
        setRotate45.addAnimation(animRotate45);

        // l_1 translate up

        Animation animTranslateL_1 = new TranslateAnimation(0, 0, 0, (l_2.getY() - l_1.getY())/2);
        animTranslateL_1.setDuration(2000);
        animTranslateL_1.setFillAfter(true);
        animTranslateL_1.setFillEnabled(true);

        AnimationSet setTranslateL_1 = new AnimationSet(true);
        setTranslateL_1.addAnimation(animRotate45);
        setTranslateL_1.addAnimation(animTranslateL_1);
        setTranslateL_1.setFillAfter(true);
        setTranslateL_1.setFillEnabled(true);
        l_1.startAnimation(setTranslateL_1);

        // l_2 translate down

        Animation animTranslateL_2 = new TranslateAnimation(0, 0, 0, -(l_2.getY() - l_1.getY())/2);
        animTranslateL_2.setDuration(2000);
        animTranslateL_2.setFillAfter(true);
        animTranslateL_2.setFillEnabled(true);

        final AnimationSet setTranslateL_2 = new AnimationSet(true);
        setTranslateL_2.addAnimation(animRotate45);
        setTranslateL_2.addAnimation(animTranslateL_2);
        setTranslateL_2.setFillAfter(true);
        setTranslateL_2.setFillEnabled(true);

        // object rotate 720

        final RotateAnimation animRotate720 = new RotateAnimation(0.0f, 2160.0f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        animRotate720.setDuration(3000);
        animRotate720.setFillAfter(true);

        final AnimationSet setRotate720 = new AnimationSet(true);
        setRotate720.setInterpolator(new DecelerateInterpolator());
        setRotate720.setFillAfter(true);
        setRotate720.setFillEnabled(true);
        setRotate720.addAnimation(animRotate720);

        // cloudds1 animation

        final Animation animClouds1= new TranslateAnimation(0, displayWidth, 0, 0);
        animClouds1.setDuration(3000);
        animClouds1.setFillAfter(true);
        animClouds1.setFillEnabled(true);

        final AnimationSet setClouds1 = new AnimationSet(true);
        setClouds1.addAnimation(animClouds1);
        setClouds1.setFillAfter(true);
        setClouds1.setFillEnabled(true);

        // clouds2 animation

        final Animation animClouds2= new TranslateAnimation(0, -displayWidth, 0, 0);
        animClouds2.setDuration(3000);
        animClouds2.setFillAfter(true);
        animClouds2.setFillEnabled(true);

        final AnimationSet setClouds2 = new AnimationSet(true);
        setClouds2.addAnimation(animClouds2);
        setClouds2.setFillAfter(true);
        setClouds2.setFillEnabled(true);

        // animation listener
        setTranslateL_1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                l_2.startAnimation(setTranslateL_2);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                relativeLayout.startAnimation(setRotate720);

                clouds1.startAnimation(setClouds1);
                clouds2.startAnimation(setClouds2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {  }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.l_1:
                startAnimation3();
                break;
            case R.id.l_2:
                startAnimation3();
                break;
        }
    }
}
