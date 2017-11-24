package com.example.administrator.android_study;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.android_study.db.DBManager;

import java.util.ArrayList;

public class DbTest01Activity extends AppCompatActivity {
    DBManager dbManager;
    TextView db_text01;
    TextView db_text02;
    EditText db_edit01;
    EditText db_edit02;
    Button db_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_test01);
        ArrayList<DbTest01Activity> dbTest01Activities = new ArrayList<>();

        // DB 클래스 생성자 생성, context: DB 클래스에서 사용하는 부모도 메인에서 사용가능 하게 함, name: db이름 설정
        dbManager = new DBManager(DbTest01Activity.this, "Bookmanager.db", null, 1 );

        db_text01 = findViewById(R.id.db_text01);
        db_text02 = findViewById(R.id.db_text02);
        db_edit01 = findViewById(R.id.db_edit01);
        db_edit02 = findViewById(R.id.db_edit02);
        db_btn = findViewById(R.id.db_btn);

        db_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = db_edit01.getText().toString();
                String price = db_edit02.getText().toString();

                dbManager.insert(name, price);
                dbManager.test();
            }
        });
    }
}
