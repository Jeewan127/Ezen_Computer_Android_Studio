package kr.co.ezenac.tbja.sampledev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Exam15Activity extends AppCompatActivity {
    Button btn_start_act1;
    Button btn_start_act2;
    TextView text_res_1;
    TextView text_res_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam15);

        btn_start_act1 = findViewById(R.id.btn_start_act1);
        btn_start_act2 = findViewById(R.id.btn_start_act2);
        text_res_1 = findViewById(R.id.text_res_1);
        text_res_2 = findViewById(R.id.text_res_2);

        btn_start_act1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exam15Activity.this,Exam15_1Activity.class);
                startActivityForResult(intent,0);
            }
        });

        btn_start_act2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exam15Activity.this,Exam15_2Activity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String str = data.getStringExtra("str");

                text_res_1.setText(str);
            }
        } else if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String text = data.getStringExtra("text");

                text_res_2.setText(text);
            }
        }
    }
}
