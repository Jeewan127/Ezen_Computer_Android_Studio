package com.example.administrator.notepad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    EditText notepad_input_title;
    EditText notepad_input_context;
    Button notepad_input_finish;

    String input_title;
    String input_context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        notepad_input_title = findViewById(R.id.notepad_input_title);
        notepad_input_context = findViewById(R.id.notepad_input_context);
        notepad_input_finish = findViewById(R.id.notepad_input_finish);

        notepad_input_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_title = notepad_input_title.getText().toString();
                input_context = notepad_input_context.getText().toString();

                Intent intent = getIntent();
                intent.putExtra("title", input_title);
                intent.putExtra("context", input_context);
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }
}
