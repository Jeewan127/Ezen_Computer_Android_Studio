package com.example.administrator.calendardiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

   /* @BindView(R.id.calendarView)
    MaterialCalendarView materialCalendarView;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
