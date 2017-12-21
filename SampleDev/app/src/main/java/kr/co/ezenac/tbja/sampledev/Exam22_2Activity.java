package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class Exam22_2Activity extends AppCompatActivity {
    EditText et_number_1;
    EditText et_number_2;
    TextView text_answer_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam22_2);

        et_number_1 = findViewById(R.id.et_number_1);
        et_number_2 = findViewById(R.id.et_number_2);
        text_answer_1 = findViewById(R.id.text_answer_1);

        et_number_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                calc();
            }
        });

        et_number_2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                calc();
            }
        });
    }

    public void calc() {
        String num1 = et_number_1.getText().toString();
        String num2 = et_number_2.getText().toString();

        if (num1.equals("")) {
            num1 = "0";
        }

        if (num2.equals("")) {
            num2 = "0";
        }

        Integer number1 = Integer.parseInt(num1);
        Integer number2 = Integer.parseInt(num2);
        Integer sum = number1 + number2;

        text_answer_1.setText(sum.toString());
    }
}
