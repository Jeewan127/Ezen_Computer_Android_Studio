package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Exam3Activity extends AppCompatActivity {
    EditText et_number;
    EditText et_number2;
    Button btn_check;
    TextView text_answer;
    Integer tmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam3);

        et_number = findViewById(R.id.et_number);
        et_number2 = findViewById(R.id.et_number2);
        btn_check = findViewById(R.id.btn_check);
        text_answer = findViewById(R.id.text_answer);

        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number1 = et_number.getText().toString();
                String number2 = et_number2.getText().toString();
                Integer res = Integer.parseInt(number1) + Integer.parseInt(number2);

                tmp = 100;
                text_answer.setText(res.toString());
            }
        });
    }
}
