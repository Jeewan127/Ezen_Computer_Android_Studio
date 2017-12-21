package kr.co.ezenac.tbja.sampledev;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.time.Year;
import java.util.Calendar;

import kr.co.ezenac.tbja.sampledev.customview.CustomDialog;

public class DialogActivity extends AppCompatActivity {
    Button btn_dialog;
    Button btn_dialog2;
    Button btn_dialog3;
    Button btn_dialog4;
    Button btn_dialog5;
    Button btn_dialog6;
    int selectedPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        btn_dialog = findViewById(R.id.btn_dialog);
        btn_dialog2 = findViewById(R.id.btn_dialog2);
        btn_dialog3 = findViewById(R.id.btn_dialog3);
        btn_dialog4 = findViewById(R.id.btn_dialog4);
        btn_dialog5 = findViewById(R.id.btn_dialog5);
        btn_dialog6 = findViewById(R.id.btn_dialog6);

        btn_dialog6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog customDialog = new CustomDialog(DialogActivity.this);
                customDialog.setCallBacks(new CustomDialog.CallBacks() {
                    @Override
                    public void onClickColor(String color) {
                        btn_dialog6.setBackgroundColor(Color.parseColor(color));
                    }
                });
                customDialog.show();
            }
        });

        btn_dialog5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int cyear = c.get(Calendar.YEAR);
                int cmonth = c.get(Calendar.MONTH);
                int cday = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        Log.d("ksj",year + " " + month + " " + day);
                    }
                };

                DatePickerDialog dialog = new DatePickerDialog(DialogActivity.this,dateSetListener,
                        cyear,cmonth,cday);
                dialog.show();
            }
        });

        btn_dialog4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        Log.d("ksj","hour : " + hour + " min : " + minute);
                    }
                };

                Calendar cal = Calendar.getInstance();
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int minute = cal.get(Calendar.MINUTE);

                TimePickerDialog dialog = new TimePickerDialog(DialogActivity.this,
                        timeSetListener,hour,minute,false);
                dialog.show();

            }
        });

        btn_dialog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog dialog = ProgressDialog.show(DialogActivity.this,
                        "Title", "로딩중..", true);
                dialog.setCancelable(true);
                //dialog.dismiss();
            }
        });

        btn_dialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String items[] = {"아이템1","아이템2","아이템3"};

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(DialogActivity.this);
                alertDialog.setTitle("타이틀");
                alertDialog.setSingleChoiceItems(items, selectedPos, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("ksj","i : " + i);
                        selectedPos = i;
                    }
                });
                alertDialog.setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("ksj","i : " + selectedPos);
                    }
                });
                alertDialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("ksj","i : " + selectedPos);
                    }
                });
                alertDialog.show();
            }
        });

        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(DialogActivity.this);
                alertDialog.setTitle("경고");
                alertDialog.setMessage("정말 삭제하시겠습니까?");
                alertDialog.setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alertDialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alertDialog.show();
            }
        });
    }
}
