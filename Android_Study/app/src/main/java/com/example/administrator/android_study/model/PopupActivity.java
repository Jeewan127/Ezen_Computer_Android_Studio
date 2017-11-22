package com.example.administrator.android_study.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.administrator.android_study.R;

public class PopupActivity extends AppCompatActivity {

    Button popup_show_btn;
    RelativeLayout popup;
//    boolean open_popup = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        popup_show_btn = findViewById(R.id.popup_show_btn);
        popup = findViewById(R.id.popup);

        popup_show_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(popup.getVisibility() == View.GONE) {  // popup이 숨겨져 있으면 보이게 하고 아니면 숨기게 하기
                    popup.setVisibility(View.VISIBLE);
                } else {
                    popup.setVisibility(View.GONE);
                }
            }
        });
    }
}
