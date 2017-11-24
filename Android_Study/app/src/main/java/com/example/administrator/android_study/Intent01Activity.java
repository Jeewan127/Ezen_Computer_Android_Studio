package com.example.administrator.android_study;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Intent01Activity extends AppCompatActivity {

    EditText intent_act1_edit;
    Button intent_act1_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent01);

        intent_act1_edit = findViewById(R.id.intent_act1_edit);
        intent_act1_btn = findViewById(R.id.intent_act1_btn);

        intent_act1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = intent_act1_edit.getText().toString();

                Intent intent = getIntent();
                intent.putExtra("text01", str);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
