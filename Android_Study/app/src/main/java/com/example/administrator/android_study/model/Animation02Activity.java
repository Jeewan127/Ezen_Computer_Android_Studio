package com.example.administrator.android_study.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.administrator.android_study.R;

public class Animation02Activity extends AppCompatActivity {

    View animation02_view01;
    View animation02_view02;
    Button animation02_btn01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation02);

        animation02_view01 = findViewById(R.id.animation02_view01);
        animation02_view02 = findViewById(R.id.animation02_view02);
        animation02_btn01 = findViewById(R.id.animation02_btn01);

        animation02_btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(animation02_view02.getVisibility() == View.GONE) {
                    Animation anim1 = AnimationUtils.loadAnimation(Animation02Activity.this, R.anim.translate);
                    animation02_view01.startAnimation(anim1);
                    anim1.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            animation02_view01.setVisibility(View.GONE);
                            animation02_view02.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                } else if(animation02_view02.getVisibility() == View.VISIBLE) {
                    Animation anim2 = AnimationUtils.loadAnimation(Animation02Activity.this, R.anim.translate2);
                    animation02_view02.startAnimation(anim2);
                    anim2.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            animation02_view02.setVisibility(View.GONE);
                            animation02_view01.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                }
            }
        });
    }
}
