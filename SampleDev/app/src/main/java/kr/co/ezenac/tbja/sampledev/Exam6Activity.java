package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Exam6Activity extends AppCompatActivity {
    EditText et_number_1;
    EditText et_number_2;
    Button btn_check_res;
    TextView text_res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam6);

        et_number_1 = findViewById(R.id.et_number_1);
        et_number_2 = findViewById(R.id.et_number_2);
        btn_check_res = findViewById(R.id.btn_check_res);
        text_res = findViewById(R.id.text_res);

        btn_check_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = et_number_1.getText().toString();
                String number2 = et_number_2.getText().toString();
                Integer num = Integer.parseInt(number);
                Integer num2 = Integer.parseInt(number2);

                Integer sum = 0;
                for (int i = num ; i <= num2 ; i++) {
                    sum += i;
                }

                text_res.setText(sum.toString());
            }
        });

    }
}
