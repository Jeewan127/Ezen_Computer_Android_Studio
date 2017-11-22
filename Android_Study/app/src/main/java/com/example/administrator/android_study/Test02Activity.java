package com.example.administrator.android_study;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Test02Activity extends AppCompatActivity {

    EditText edit_input;
    TextView text_output;
    Button btn_change;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test02);

        edit_input = (EditText) findViewById(R.id.edit_input);
        text_output = (TextView) findViewById(R.id.text_output);
        btn_change = (Button) findViewById(R.id.btn_change);

        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = edit_input.getText().toString();
                str = str.replace("1", "a");
                str = str.replace("2", "b");
                str = str.replace("3", "c");
                str = str.replace("4", "d");
                str = str.replace("5", "e");
                text_output.setText(str.toString());
            }
        });
    }
}
