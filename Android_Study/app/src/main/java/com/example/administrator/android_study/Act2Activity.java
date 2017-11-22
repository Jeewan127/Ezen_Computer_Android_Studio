package com.example.administrator.android_study;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Act2Activity extends AppCompatActivity {
    Button btn_send;
    EditText et_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);

        btn_send = findViewById(R.id.btn_send);
        et_text = findViewById(R.id.et_text);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = et_text.getText().toString();

                Intent intent = getIntent();
                intent.putExtra("etText",str);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
