package kr.co.ezenac.tbja.sampledev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity2Activity extends AppCompatActivity {
    Button btn_finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        Intent intent = getIntent();
        Integer number = intent.getIntExtra("count",0);
        String str = intent.getStringExtra("str");

        Log.d("ksj","number : " + number + "  str : " + str);

        btn_finish = findViewById(R.id.btn_finish);
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
