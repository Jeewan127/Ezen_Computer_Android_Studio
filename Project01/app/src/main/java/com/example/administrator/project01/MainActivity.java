package com.example.administrator.project01;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.project01.adapter.MainViewAdapter;
import com.example.administrator.project01.db.DBManager;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    DBManager dbManager;
    ListView main_listview;
    MainViewAdapter mainViewAdapter;
    Button main_plus_button;
    TextView main_act_textView1;
    ArrayList<Housekeep> housekeeps = new ArrayList<>();

    int ayear;
    int amonth;
    int aday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_listview = findViewById(R.id.main_listview);
        main_plus_button = findViewById(R.id.main_plus_button);
        main_act_textView1 = findViewById(R.id.main_act_textView1);

        Calendar c = Calendar.getInstance();
        ayear = c.get(Calendar.YEAR);
        amonth = c.get(Calendar.MONTH);
        aday = c.get(Calendar.DAY_OF_MONTH);

        setDate(ayear, amonth, aday);



        dbManager = new DBManager(MainActivity.this, "Housekeep.db", null, 1); // db 생성
        housekeeps = dbManager.getCostList(ayear, amonth, aday);

        mainViewAdapter = new MainViewAdapter(MainActivity.this, housekeeps, dbManager);          // MainViewAdapter 생성자 생성,
        main_listview.setAdapter(mainViewAdapter);   // 연결 리스트뷰에 사용할 데이터 객체(mainViewAdapter)를 넘겨줌

        main_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {   // ListView를 클릭 했을 때 동작
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Housekeep item = housekeeps.get(position);      // Arraylist에서 위치 값을 받아와 item에 저장

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class); // Intent 생성, DetailsActivity와 연결
                intent.putExtra("cost", item.getCost()); // cost란 이름으로 Housekeep 클래스에 있는 cost값을 보냄
                intent.putExtra("type", item.getType()); // type이란 이름으로 Housekeep 클래스에 있는 type값을 보냄
                intent.putExtra("pos", position); // pos란 이름으로 position값을 보냄
                intent.putExtra("id", item.getId());
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

        main_act_textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        ayear = year;
                        amonth = month;
                        aday = dayOfMonth;
                        setDate(ayear, amonth, aday);
                        refeshList(ayear, amonth, aday);
                    }
                };
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, dateSetListener, ayear, amonth, aday);
                dialog.show();
            }
        });


        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
            }
        };

        TedPermission.with(MainActivity.this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.RECEIVE_SMS)
                .check();

    }

    // onActivityResult: A에서 B로 갔다가 다시 A로 넘어 올때 사용
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0) {  // 고유 번호가 0번일 때
            if (resultCode == RESULT_OK) {  // resultCode가 OK사인을 보냈을 때
                Integer cost = data.getIntExtra("cost", 0); // intent data에 저장되어 있는 cost이름을 가진 데이터 값을 Integer cost에 넣어줌
                Integer type = data.getIntExtra("type", 0); // intent data에 저장되어 있는 type이름을 가진 데이터 값을 Integer type에 넣어줌
                Integer year = data.getIntExtra("year", 0);
                Integer month = data.getIntExtra("month", 0);
                Integer day = data.getIntExtra("day", 0);

                dbManager.insertData(type, cost, year, month, day);
                refeshList(ayear, amonth, aday);
            }
        } else if(requestCode == 1) {
            if(resultCode == RESULT_OK) {   // setResult에서 RESULT_OK를 받았으면
                int pos = data.getIntExtra("pos", 0);   // Intent가 보낸 pos의 이름의 데이터를 pos에 저장
                int id = data.getIntExtra("id", 0);
                housekeeps.remove(pos);
                dbManager.deleteData(id);
                mainViewAdapter.notifyDataSetChanged();
            }
        }
    }

    public void setDate(Integer year, Integer month, Integer day) {
        main_act_textView1.setText(year + "/" + (month+1) + "/" + day);
    }

    public void refeshList(Integer year,Integer month, Integer day) {
        setDate(year,month,day);
        housekeeps = dbManager.getCostList(year,month,day);
        mainViewAdapter = new MainViewAdapter(MainActivity.this, housekeeps, dbManager);
        main_listview.setAdapter(mainViewAdapter);
    }
}
