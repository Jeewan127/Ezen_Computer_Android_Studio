package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Exam2Activity extends AppCompatActivity {
    TextView text_number1;
    TextView text_number2;
    TextView text_op;
    TextView text_answer;
    Button btn_plus;
    Button btn_minus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam2);

        text_number1 = findViewById(R.id.text_number1);
        text_number2 = findViewById(R.id.text_number2);
        text_op = findViewById(R.id.text_op);
        text_answer = findViewById(R.id.text_answer);
        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number1 = text_number1.getText().toString();
                String number2 = text_number2.getText().toString();

                Log.d("ksj","number1 : " + number1);

                Integer res = Integer.parseInt(number1) + Integer.parseInt(number2);
                text_op.setText("+");
                text_answer.setText(res.toString());
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number1 = text_number1.getText().toString();
                String number2 = text_number2.getText().toString();
                Integer res = Integer.parseInt(number1) - Integer.parseInt(number2);

                text_op.setText("-");
                text_answer.setText(res.toString());
            }
        });

    }
}
