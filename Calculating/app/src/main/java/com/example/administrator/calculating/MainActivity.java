package com.example.administrator.calculating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static Integer PLUS = 0;
    public static Integer MINUS = 1;
    public static Integer DIV = 2;
    public static Integer MULTI = 3;

    Button btn_num_0;
    Button btn_num_1;
    Button btn_num_2;
    Button btn_num_3;
    Button btn_num_4;
    Button btn_num_5;
    Button btn_num_6;
    Button btn_num_7;
    Button btn_num_8;
    Button btn_num_9;
    TextView input_str;

    Button btn_num_division;
    Button btn_num_multi;
    Button btn_num_minus;
    Button btn_num_plus;
    Button btn_result;
    Button btn_clear;

    int num1 = 0;
    int num2 = 0;

    int op = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_num_0 = (Button) findViewById(R.id.btn_num_0);
        btn_num_1 = (Button) findViewById(R.id.btn_num_1);
        btn_num_2 = (Button) findViewById(R.id.btn_num_2);
        btn_num_3 = (Button) findViewById(R.id.btn_num_3);
        btn_num_4 = (Button) findViewById(R.id.btn_num_4);
        btn_num_5 = (Button) findViewById(R.id.btn_num_5);
        btn_num_6 = (Button) findViewById(R.id.btn_num_6);
        btn_num_7 = (Button) findViewById(R.id.btn_num_7);
        btn_num_8 = (Button) findViewById(R.id.btn_num_8);
        btn_num_9 = (Button) findViewById(R.id.btn_num_9);
        input_str = (TextView) findViewById(R.id.input_str);
        btn_num_division = (Button) findViewById(R.id.btn_num_division);
        btn_num_multi = (Button) findViewById(R.id.btn_num_multi);
        btn_num_minus = (Button) findViewById(R.id.btn_num_minus);
        btn_num_plus = (Button) findViewById(R.id.btn_num_plus);
        btn_result = (Button) findViewById(R.id.btn_result);
        btn_clear = (Button) findViewById(R.id.btn_clear);

        btn_num_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_str.setText(input_str.getText().toString() + "0");
            }
        });

        btn_num_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_str.setText(input_str.getText().toString() + "1");
            }
        });

        btn_num_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_str.setText(input_str.getText().toString() + "2");
            }
        });

        btn_num_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_str.setText(input_str.getText().toString() + "3");
            }
        });

        btn_num_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_str.setText(input_str.getText().toString() + "4");
            }
        });

        btn_num_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_str.setText(input_str.getText().toString() + "5");
            }
        });

        btn_num_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_str.setText(input_str.getText().toString() + "6");
            }
        });

        btn_num_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_str.setText(input_str.getText().toString() + "7");
            }
        });


        btn_num_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_str.setText(input_str.getText().toString() + "8");
            }
        });

        btn_num_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_str.setText(input_str.getText().toString() + "9");
            }
        });

        btn_num_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(input_str.getText().toString());

                op = DIV;

                input_str.setText("");
            }
        });

        btn_num_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(input_str.getText().toString());

                op = MULTI;

                input_str.setText("");
            }
        });

        btn_num_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(input_str.getText().toString());

                op = MINUS;

                input_str.setText("");
            }
        });

        btn_num_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(input_str.getText().toString());

                op = PLUS;

                input_str.setText("");
            }
        });

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2 = Integer.parseInt(input_str.getText().toString());

                if (op == MINUS) {
                    input_str.setText( ((Integer)(num1 - num2)).toString() );
                } else if (op == PLUS) {
                    input_str.setText( ((Integer)(num1 + num2)).toString() );
                } else if (op == DIV) {
                    input_str.setText( ((Integer)(num1 / num2)).toString() );
                } else if (op == MULTI) {
                    input_str.setText( ((Integer)(num1 * num2)).toString() );
                }
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_str.setText("");
                num1 = 0;
                num2 = 0;
                op = -1;
            }
        });
    }
}
