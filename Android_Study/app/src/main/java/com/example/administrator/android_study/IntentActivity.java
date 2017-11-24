package com.example.administrator.android_study;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IntentActivity extends AppCompatActivity {

    Button intent_main_btn1;
    Button intent_main_btn2;

    TextView intent_main_text1;
    TextView intent_main_text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        intent_main_btn1 = findViewById(R.id.intent_main_btn1);
        intent_main_btn2 = findViewById(R.id.intent_main_btn2);
        intent_main_text1 = findViewById(R.id.intent_main_text1);
        intent_main_text2 = findViewById(R.id.intent_main_text2);

        intent_main_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentActivity.this, Intent01Activity.class);
                startActivityForResult(intent, 0);
            }
        });

        intent_main_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentActivity.this, Intent02Activity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    // onActivityResult: A에서 B로 갔다가 다시 A로 넘어 올때 사용
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0) {      // 고유 번호가 0번일 때
            if(resultCode == RESULT_OK) {  // resultCode가 OK사인을 보냈을 때
                String text1 = data.getStringExtra("text01"); //text01에 intent data에 text01이름 을 가진 스트링 데이터를 가져옴
                intent_main_text1.setText(text1);   // 텍스트에 text01데이터 값을 넣어줌
            }
        } else if(requestCode == 1) {   // 고유 번호가 1번일 때
            if(resultCode == RESULT_OK) { // resultCode가 OK사인을 보냈을 때
                String text = data.getStringExtra("text02"); // //text02에 intent data에 text01이름 을 가진 스트링 데이터를 가져옴
                intent_main_text2.setText(text);  // 텍스트에 text02데이터 값을 넣어줌
            }
        }
    }
}
