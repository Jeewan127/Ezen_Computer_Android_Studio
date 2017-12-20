package com.example.administrator.android_study;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btn_change;
    TextView text_change;
    Button btn_sum;
    TextView text_number_1;
    TextView text_number_2;
    TextView text_number_3;

    Button result_1;
    EditText edit_1;
    EditText edit_2;
    TextView text_1;

    Button third_sum;
    Button third_minus;
    TextView third_text1;
    TextView third_text2;
    TextView third_text3;
    TextView third_text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onclick_exam01);

        btn_change = (Button)findViewById(R.id.btn_change);
        text_change = (TextView)findViewById(R.id.text_change);
        btn_sum = (Button)findViewById(R.id.btn_sum);
        text_number_1 = (TextView) findViewById(R.id.text_number_1);
        text_number_2 = (TextView) findViewById(R.id.text_number_2);
        text_number_3 = (TextView) findViewById(R.id.text_number_3);

        result_1 = (Button)findViewById(R.id.result_1);
        edit_1 = (EditText)findViewById(R.id.edit_1);
        edit_2 = (EditText)findViewById(R.id.edit_2);
        text_1 = (TextView)findViewById(R.id.text_1);

        third_sum = (Button)findViewById(R.id.third_sum);
        third_minus = (Button)findViewById(R.id.third_minus);
        third_text1 = (TextView)findViewById(R.id.third_text1);
        third_text2 = (TextView)findViewById(R.id.third_text2);
        third_text3 = (TextView)findViewById(R.id.third_text3);
        third_text4 = (TextView)findViewById(R.id.third_text4);

        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("first", "onclick");
                String number1 = text_number_1.getText().toString();
                String number2 = text_number_2.getText().toString();
                Integer res = Integer.parseInt(number1) + Integer.parseInt(number2);
                text_number_3.setText(res.toString());
            }
        });

        /*btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_change.setText(getString(R.string.hello));
            }
        });*/

        result_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = edit_1.getText().toString();
                String num2 = edit_2.getText().toString();
                Log.d("second", "onClick: "+num1);
                Integer res = Integer.parseInt(num1) + Integer.parseInt(num2);
                text_1.setText(res.toString());
            }
        });

        /*third_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = third_text1.getText().toString();
                String num2 = third_text2.getText().toString();
                Integer res = Integer.parseInt(num1) + Integer.parseInt(num2);
                third_text4.setText(getString(R.string.sum));
                third_text3.setText(res.toString());
            }
        });*/

        /*third_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = third_text1.getText().toString();
                String num2 = third_text2.getText().toString();
                Integer res = Integer.parseInt(num1) - Integer.parseInt(num2);
                third_text4.setText(getString(R.string.minus));
                third_text3.setText(res.toString());
            }
        });*/


    }
}
