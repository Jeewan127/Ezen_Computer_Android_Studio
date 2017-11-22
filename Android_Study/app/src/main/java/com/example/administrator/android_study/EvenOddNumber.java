package com.example.administrator.android_study;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EvenOddNumber extends AppCompatActivity {

    EditText edit;
    TextView text;
    Button btn;
    Button btn_rotation;
    Button btn_scale;
    Button btn_translate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_even_odd_number);

        edit = (EditText)findViewById(R.id.edit);
        text = (TextView)findViewById(R.id.text);
        btn = (Button)findViewById(R.id.btn);
        btn_rotation = (Button)findViewById(R.id.btn_rotation);
        btn_scale = (Button)findViewById(R.id.btn_scale);
        btn_translate = (Button)findViewById(R.id.btn_translate);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(EvenOddNumber.this,R.anim.alpha);
                btn.startAnimation(anim);
                String num = edit.getText().toString();
                Integer res = Integer.parseInt(num);
                if(res%2 == 0) {
                    text.setText("짝수");
                } else if(res%2 == 1) {
                    text.setText("홀수");
                }
            }
        });

        btn_rotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(EvenOddNumber.this, R.anim.rotate);
                btn_rotation.startAnimation(anim);
                String num = edit.getText().toString();
                Integer res = Integer.parseInt(num);
                if(res%2 == 0) {
                    text.setText("짝수");
                } else if(res%2 == 1) {
                    text.setText("홀수");
                }
            }
        });

        btn_scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(EvenOddNumber.this, R.anim.scale);
                btn_scale.startAnimation(anim);
            }
        });


    }
}
