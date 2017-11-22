package com.example.administrator.project01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InputActivity extends AppCompatActivity {

/*    Date date1;
    String getTime;*/

    Button x_button;
    TextView date;

    EditText input_price;

    Button deposit;
    Button expense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_layout);

        x_button = (Button)findViewById(R.id.x_button);
        date = (TextView)findViewById(R.id.date);

        input_price = (EditText)findViewById(R.id.input_price);

        deposit = (Button)findViewById(R.id.deposit);
        expense = (Button)findViewById(R.id.expense);

        x_button.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
               finish();
           }
        });

        expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cost = input_price.getText().toString();
                if(cost.equals("") || cost.equals("0")) {
                    return;
                }

                int type = 0; // 지출

                Intent intent = getIntent();
                intent.putExtra("cost", Integer.parseInt(cost));
                intent.putExtra("type", type);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cost = input_price.getText().toString();

                int type = 1;

                Intent intent = getIntent();
                intent.putExtra("cost", Integer.parseInt(cost));
                intent.putExtra("type", type);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

}

