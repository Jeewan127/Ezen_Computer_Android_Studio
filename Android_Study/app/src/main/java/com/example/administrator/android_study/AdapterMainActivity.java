package com.example.administrator.android_study;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.administrator.android_study.adapter.ListViewAdapter;
import com.example.administrator.android_study.model.Friend;

import java.util.ArrayList;

public class AdapterMainActivity extends AppCompatActivity {

    ListView listview_fri;
    ListViewAdapter listViewAdapter;
    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_main);

        listview_fri = findViewById(R.id.listview_fri);

        for(int i=0; i<100; i++) {
            Friend friend = new Friend("Jee Wan_" + i, "0" + i, (int)(Math.random()*2));
            friends.add(friend);
        }

        listViewAdapter = new ListViewAdapter(friends);
        listview_fri.setAdapter(listViewAdapter);
    }
}
