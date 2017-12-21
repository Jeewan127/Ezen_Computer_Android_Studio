package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Exam7Activity extends AppCompatActivity {
    Button btn_plus_1;
    Button btn_plus_2;
    Button btn_plus_3;
    Button btn_plus_4;
    TextView text_number_1;
    TextView text_number_2;
    TextView text_ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam7);

        btn_plus_1 = findViewById(R.id.btn_plus_1);
        btn_plus_2 = findViewById(R.id.btn_plus_2);
        btn_plus_3 = findViewById(R.id.btn_plus_3);
        btn_plus_4 = findViewById(R.id.btn_plus_4);
        text_number_1 = findViewById(R.id.text_number_1);
        text_number_2 = findViewById(R.id.text_number_2);
        text_ans = findViewById(R.id.text_ans);

        btn_plus_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = text_number_1.getText().toString();
                Integer num = Integer.parseInt(number);
                num += 1;
                text_number_1.setText(num.toString());

                sum();
            }
        });

        btn_plus_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = text_number_1.getText().toString();
                Integer num = Integer.parseInt(number);
                num -= 1;
                text_number_1.setText(num.toString());

                sum();
            }
        });

        btn_plus_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = text_number_2.getText().toString();
                Integer num = Integer.parseInt(number);
                num += 1;
                text_number_2.setText(num.toString());

                sum();
            }
        });

        btn_plus_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = text_number_2.getText().toString();
                Integer num = Integer.parseInt(number);
                num -= 1;
                text_number_2.setText(num.toString());

                sum();
            }
        });
    }

    public void sum() {
        String number =text_number_1.getText().toString();
        String number2 = text_number_2.getText().toString();
        Integer num = Integer.parseInt(number);
        Integer num2 = Integer.parseInt(number2);
        Integer res = num + num2;

        text_ans.setText(res.toString());
    }
}
