package com.example.administrator.android_study;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Intent02Activity extends AppCompatActivity {

    EditText intent_act2_edit;
    Button intent_act2_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent02);

        intent_act2_edit = findViewById(R.id.intent_act2_edit);
        intent_act2_btn = findViewById(R.id.intent_act2_btn);

        intent_act2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = intent_act2_edit.getText().toString();

                Intent intent = getIntent();
                intent.putExtra("text02", str);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
