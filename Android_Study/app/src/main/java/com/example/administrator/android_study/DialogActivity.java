package com.example.administrator.android_study;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.android_study.costomdialogview.CustomDIalog;

public class DialogActivity extends AppCompatActivity {

    Button dialog_btn;
    Button dialog_btn2;
    Button dialog_btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        dialog_btn = findViewById(R.id.dialog_btn);
        dialog_btn2 = findViewById(R.id.dialog_btn2);
        dialog_btn3 = findViewById(R.id.dialog_btn3);

        dialog_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(DialogActivity.this);
                alertDialog.setTitle("경고");
                alertDialog.setMessage("다시한번생각해");

                alertDialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
           }
        });

        // 여러개의 선택창을 띄어 선택하는 다이얼로그
        dialog_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String items[] = {"아이템1","아이템2", "아이템3"};

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(DialogActivity.this);
                alertDialog.setTitle("타이틀");
                alertDialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                alertDialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
            }
        });

        dialog_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDIalog customDIalog = new CustomDIalog(DialogActivity.this);
                customDIalog.setCallBacks(new CustomDIalog.CallBacks() {
                    @Override
                    public void onClickColor(String color) {
                        dialog_btn3.setBackgroundColor(Color.parseColor(color));
                    }
                });
                customDIalog.show();
            }
        });
    }
}
