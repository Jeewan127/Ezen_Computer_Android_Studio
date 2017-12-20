package com.example.administrator.android_study.costomdialogview;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.android_study.R;

/**
 * Created by Administrator on 2017-11-28.
 */

public class CustomDIalog extends Dialog {
    ImageView dialog_img01;
    ImageView dialog_img02;
    ImageView dialog_img03;
    ImageView dialog_img04;

    CallBacks callBacks = null;

    public interface CallBacks {    // 인터페이스를 제일 먼저 생성
         void onClickColor(String color);
    }

    public void setCallBacks(CallBacks callBacks) {
        this.callBacks = callBacks;
    }

    public CustomDIalog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.custom_dialog);

        dialog_img01 = findViewById(R.id.dialog_img01);
        dialog_img02 = findViewById(R.id.dialog_img02);
        dialog_img03 = findViewById(R.id.dialog_img03);
        dialog_img04 = findViewById(R.id.dialog_img04);

        dialog_img01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickColor("#00ffff");
            }
        });
        dialog_img02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickColor("#0000ff");
            }
        });
        dialog_img03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickColor("#ff0d00");
            }
        });
        dialog_img04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickColor("#ffff00");
            }
        });
    }
    public void clickColor(String color) {
        if(callBacks != null) {
            callBacks.onClickColor(color);
        }
        dismiss();
    }
}
