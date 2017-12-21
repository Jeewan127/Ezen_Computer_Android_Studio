package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class Exam22Activity extends AppCompatActivity {
    EditText et_num1;
    EditText et_num2;
    EditText et_op;
    TextView text_answ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam22);

        et_num1 = findViewById(R.id.et_num1);
        et_num2 = findViewById(R.id.et_num2);
        text_answ = findViewById(R.id.text_answ);
        et_op = findViewById(R.id.et_op);

        et_num1.addTextChangedListener(new TextWatcher() {
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

        et_num2.addTextChangedListener(new TextWatcher() {
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

        et_op.addTextChangedListener(new TextWatcher() {
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
        String num1 = et_num1.getText().toString();
        String num2 = et_num2.getText().toString();
        String op = et_op.getText().toString();

        if (num1.equals("")) {
            num1 = "0";
        }

        if (num2.equals("")) {
            num2 = "0";
        }
        Integer number1 = Integer.parseInt(num1);
        Integer number2 = Integer.parseInt(num2);

        Integer sum = 0;
        switch (op) {
            case "+":
                sum = number1 + number2;
                break;
            case "-":
                sum = number1 - number2;
                break;
            case "*":
                sum = number1 * number2;
                break;
            case "/":
                sum = number1 / number2;
                break;
        }


        text_answ.setText(sum.toString());
    }
}
