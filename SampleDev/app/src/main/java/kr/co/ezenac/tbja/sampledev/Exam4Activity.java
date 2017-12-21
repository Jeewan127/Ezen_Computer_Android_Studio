package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Exam4Activity extends AppCompatActivity {
    Button btn_result;
    TextView text_answer;
    EditText et_input_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam4);

        btn_result = findViewById(R.id.btn_result);
        text_answer = findViewById(R.id.text_answer);
        et_input_number = findViewById(R.id.et_input_number2);

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = et_input_number.getText().toString();
                Integer num = Integer.parseInt(number);

                if (num % 2 == 0) {
                    text_answer.setText("짝수");
                } else {
                    text_answer.setText("홀수");
                }
            }
        });

    }
}
