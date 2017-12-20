package com.example.administrator.project01;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class InputActivity extends AppCompatActivity {

/*    Date date1;
    String getTime;*/

    Button x_button;
    TextView date;

    EditText input_price;

    Button deposit;
    Button expense;

    int cyear;
    int cmonth;
    int cday;

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

        SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd", Locale.KOREA);
        Date current = new Date();
        String time = formater.format(current);
        // 날짜 출력
        date.setText(time);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();

                cyear = c.get(Calendar.YEAR);
                cmonth = c.get(Calendar.MONTH);
                cday = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(year + "/" + (month+1) + "/" + dayOfMonth);
                        cyear = year;
                        cmonth = month;
                        cday = dayOfMonth;
                    }
                };
                DatePickerDialog dialog = new DatePickerDialog(InputActivity.this, dateSetListener, cyear, cmonth, cday);
                dialog.show();

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
                intent.putExtra("year", cyear);
                intent.putExtra("month", cmonth);
                intent.putExtra("day", cday);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cost = input_price.getText().toString();
                if(cost.equals("") || cost.equals("0")) {
                    return;
                }

                int type = 1;

                Intent intent = getIntent();
                intent.putExtra("cost", Integer.parseInt(cost));
                intent.putExtra("type", type);
                intent.putExtra("year", cyear);
                intent.putExtra("month", cmonth);
                intent.putExtra("day", cday);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

}

