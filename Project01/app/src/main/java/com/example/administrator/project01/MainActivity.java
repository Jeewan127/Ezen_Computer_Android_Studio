package com.example.administrator.project01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        // 오늘 날짜 불러 오기
        SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
        Date current = new Date();
        String time = formater.format(current);
        // 날짜 출력
        main_act_textView1.setText(time);

        mainViewAdapter = new MainViewAdapter(MainActivity.this, housekeeps);          // MainViewAdapter 생성자 생성,
        main_listview.setAdapter(mainViewAdapter);   // 연결 리스트뷰에 사용할 데이터 객체(mainViewAdapter)를 넘겨줌

        main_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {   // ListView를 클릭 했을 때 동작
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Housekeep item = housekeeps.get(position);      // Arraylist에서 위치 값을 받아와 item에 저장

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class); // Intent 생성, DetailsActivity와 연결
                intent.putExtra("cost", item.getCost()); // cost란 이름으로 Housekeep 클래스에 있는 cost값을 보냄
                intent.putExtra("type", item.getType()); // type이란 이름으로 Housekeep 클래스에 있는 type값을 보냄
                intent.putExtra("pos", position); // pos란 이름으로 position값을 보냄
                startActivityForResult(intent, 1); // DetailsActivity 클래스로 넘어감, 고유번호: 1
            }
        });

        // +버튼 클킥
        main_plus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InputActivity.class); // Intent 생성, 클릭시 InputActivity로 넘어가게 위치 지정
                startActivityForResult(intent, 0); // InputActivity 클래스로 넘어감, 고유번호: 0
            }
        });
    }

    // onActivityResult: A에서 B로 갔다가 다시 A로 넘어 올때 사용
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0) {  // 고유 번호가 0번일 때
            if (resultCode == RESULT_OK) {  // resultCode가 OK사인을 보냈을 때
                Integer cost = data.getIntExtra("cost", 0); // intent data에 저장되어 있는 cost이름을 가진 데이터 값을 Integer cost에 넣어줌
                Integer type = data.getIntExtra("type", 0); // intent data에 저장되어 있는 type이름을 가진 데이터 값을 Integer type에 넣어줌

                Housekeep item = new Housekeep(cost, type); // Housekepp 생성
                housekeeps.add(item);   // ArrayList에 item
                mainViewAdapter.notifyDataSetChanged();
            }
        } else if(requestCode == 1) {
            if(resultCode == RESULT_OK) {   // setResult에서 RESULT_OK를 받았으면
                int pos = data.getIntExtra("pos", 0);   // Intent가 보낸 pos의 이름의 데이터를 pos에 저장

                housekeeps.remove(pos);
                mainViewAdapter.notifyDataSetChanged();
            }
        }
    }
}
