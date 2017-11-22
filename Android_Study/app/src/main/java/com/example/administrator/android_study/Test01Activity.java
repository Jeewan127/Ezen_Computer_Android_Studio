package com.example.administrator.android_study;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Test01Activity extends AppCompatActivity {

    Button btn_plus1;
    TextView text1;
    Button btn_minus1;

    Button btn_plus2;
    TextView text2;
    Button btn_minus2;

    TextView result;

    Integer num1=1, num2=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test01);

        btn_plus1 = (Button)findViewById(R.id.btn_plus1);
        text1 = (TextView)findViewById(R.id.text1);
        btn_minus1 = (Button)findViewById(R.id.btn_minus1);

        btn_plus2 = (Button)findViewById(R.id.btn_plus2);
        text2 = (TextView)findViewById(R.id.text2);
        btn_minus2 = (Button)findViewById(R.id.btn_minus2);

        result = (TextView)findViewById(R.id.result);

        btn_plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = sum(text1);
                text1.setText(num1.toString());
                result.setText(resultsum(num1, num2).toString());
            }
        });

        btn_minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = minus(text1);
                text1.setText(num1.toString());
                result.setText(resultsum(num1, num2).toString());
            }
        });

        btn_plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2 = sum(text2);
                text2.setText(num2.toString());
                result.setText(resultsum(num1, num2).toString());
            }
        });

        btn_minus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2 = minus(text2);
                text2.setText(num2.toString());
                result.setText(resultsum(num1, num2).toString());
            }
        });
    }

    public static Integer sum(TextView text) {
        String str = text.getText().toString();
        Integer num = Integer.parseInt(str);
        num++;
        return num;
    }

    public static Integer minus(TextView text) {
        String str = text.getText().toString();
        Integer num = Integer.parseInt(str);
        num--;
        return num;
    }

    public static Integer resultsum(Integer num1, Integer num2) {
        Integer result = num1 + num2;
        return result;
    }

}
