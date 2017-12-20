package com.example.administrator.project01;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.project01.adapter.MainViewAdapter;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    Button details_back_btn; // 뒤로가기
    Button details_btn; // 삭제 버튼
    ImageView details_oval; // 수입, 지출에 따른 색
    TextView details_text1; // 수입 or 지출
    TextView details_text2; // 선택한 돈

    Integer pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        details_back_btn = (Button)findViewById(R.id.details_back_btn);
        details_btn = (Button)findViewById(R.id.details_btn);
        details_oval = findViewById(R.id.details_oval);
        details_text1 = findViewById(R.id.details_text1);
        details_text2 = findViewById(R.id.details_text2);

        Intent intent = getIntent();    // Intent를 받아와서 생성
        Integer type = intent.getIntExtra("type", 0); // type이름으로 있는 int형 데이터 값을 받아옴, 해당값이 없으면 0 반환
        Integer cost = intent.getIntExtra("cost", 0); // cost이름으로 있는 int형 데이터 값을 받아옴, 해당값이 없으면 0 반환
        pos = intent.getIntExtra("pos", 0); // pos이름으로 있는 값을 받아와 pos에 저장, 해당값이 없으면 0반환

        if(type == 0) {
            details_text1.setText("지출");
            details_oval.setBackgroundResource(R.drawable.oval_pink);
        }  else {
            details_text1.setText("입금");
            details_oval.setBackgroundResource(R.drawable.oval_blue);
        }

        details_text2.setText(cost.toString());

        details_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(DetailsActivity.this);
                alertDialog.setTitle("삭제");
                alertDialog.setMessage("정말 삭제 하시겠습니까?");

                alertDialog.setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = getIntent();
                        intent.putExtra("pos", pos);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
                alertDialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                alertDialog.show();
            }
        });

        details_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
