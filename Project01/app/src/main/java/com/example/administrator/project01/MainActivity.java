package com.example.administrator.project01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.project01.adapter.MainViewAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ListView main_listview;
    MainViewAdapter mainViewAdapter;
    Button main_plus_button;
    TextView main_act_textView1;
    ArrayList<Housekeep> housekeeps = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_listview = findViewById(R.id.main_listview);
        main_plus_button = findViewById(R.id.main_plus_button);
        main_act_textView1 = findViewById(R.id.main_act_textView1);

        SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
        Date current = new Date();
        String time = formater.format(current);

        main_act_textView1.setText(time);

        mainViewAdapter = new MainViewAdapter(housekeeps);
        main_listview.setAdapter(mainViewAdapter);

        main_plus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InputActivity.class);
                startActivityForResult(intent, 0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0) {
            if(resultCode == RESULT_OK) {
                Integer cost = data.getIntExtra("cost",0);
                Integer type = data.getIntExtra("type",0);

                Housekeep item = new Housekeep(cost, type);
                housekeeps.add(item);
                mainViewAdapter.notifyDataSetChanged();
            }
        }
    }
}
