package com.example.administrator.notepad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import adapter.ListviewAdapter;

public class NotepadMainActivity extends AppCompatActivity {

    ListView notepad_main_listview;
    ListviewAdapter listAdapter;
    ArrayList<Notepad> notepads = new ArrayList<>();
    Button notepad_main_plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad_main);

        notepad_main_listview =  findViewById(R.id.notepad_main_listview);
        notepad_main_plus = findViewById(R.id.notepad_main_plus);


        listAdapter = new ListviewAdapter(notepads, NotepadMainActivity.this);
        notepad_main_listview.setAdapter(listAdapter);

        notepad_main_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotepadMainActivity.this, InputActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0) {
            if(resultCode == RESULT_OK) {
                String title = data.getStringExtra("title");
                String context = data.getStringExtra("context");
                Notepad notepad = new Notepad(title);
                notepads.add(notepad);
                listAdapter.notifyDataSetChanged();
            }
        }
    }

}
