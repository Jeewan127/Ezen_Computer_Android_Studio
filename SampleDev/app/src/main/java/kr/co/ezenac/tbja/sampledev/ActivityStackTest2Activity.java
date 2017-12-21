package kr.co.ezenac.tbja.sampledev;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ActivityStackTest2Activity extends AppCompatActivity {
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_10;
    Button btn_11;
    Button btn_12;
    Button btn_13;
    Button btn_14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_test2);

        btn_13 = (Button) findViewById(R.id.btn_13);
        btn_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityStackTest2Activity.this,ActivityStackTestActivity.class);
                startActivity(intent);
            }
        });

        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityStackTest2Activity.this,ActivityStackTestActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityStackTest2Activity.this,ActivityStackTestActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityStackTest2Activity.this,ActivityStackTestActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

        btn_14 = (Button) findViewById(R.id.btn_14);
        btn_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityStackTest2Activity.this,ActivityStackTest2Activity.class);
                startActivity(intent);
            }
        });

        btn_10 = (Button) findViewById(R.id.btn_10);
        btn_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityStackTest2Activity.this,ActivityStackTest2Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        btn_11 = (Button) findViewById(R.id.btn_11);
        btn_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityStackTest2Activity.this,ActivityStackTest2Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btn_12 = (Button) findViewById(R.id.btn_12);
        btn_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityStackTest2Activity.this,ActivityStackTest2Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
    }
}
