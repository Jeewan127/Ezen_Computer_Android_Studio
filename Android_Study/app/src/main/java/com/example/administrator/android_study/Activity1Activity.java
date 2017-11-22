package com.example.administrator.android_study;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity1Activity extends AppCompatActivity {

    Button btn_start_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);

        btn_start_activity = findViewById(R.id.btn_start_activity);
        btn_start_activity.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity1Activity.this, Activity2Activity.class);
                intent.putExtra("count", 100);
                intent.putExtra("str", "test");
                startActivity(intent);
            }
        });
    }
}
