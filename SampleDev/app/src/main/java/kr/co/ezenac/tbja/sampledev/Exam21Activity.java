package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import kr.co.ezenac.tbja.sampledev.model.Book;

public class Exam21Activity extends AppCompatActivity {
    Button btn_popup_1;
    Button btn_popup_2;
    Button btn_popup_3;
    RelativeLayout popup_1;
    RelativeLayout popup_2;
    RelativeLayout popup_3;
    Button btn_popup_close_1;
    Button btn_popup_close_2;
    Button btn_popup_close_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam21);

        btn_popup_1 = findViewById(R.id.btn_popup_1);
        btn_popup_2 = findViewById(R.id.btn_popup_2);
        btn_popup_3 = findViewById(R.id.btn_popup_3);
        popup_1 = findViewById(R.id.popup_1);
        popup_2 = findViewById(R.id.popup_2);
        popup_3 = findViewById(R.id.popup_3);
        btn_popup_close_1 = findViewById(R.id.btn_popup_close_1);
        btn_popup_close_2 = findViewById(R.id.btn_popup_close_2);
        btn_popup_close_3 = findViewById(R.id.btn_popup_close_3);

        btn_popup_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup(0);
            }
        });

        btn_popup_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup(1);
            }
        });

        btn_popup_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup(2);
            }
        });
        btn_popup_close_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup_1.setVisibility(View.GONE);
            }
        });
        btn_popup_close_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup_2.setVisibility(View.GONE);
            }
        });
        btn_popup_close_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup_3.setVisibility(View.GONE);
            }
        });
    }

    public void showPopup(int index) {
        popup_1.setVisibility(View.GONE);
        popup_2.setVisibility(View.GONE);
        popup_3.setVisibility(View.GONE);

        switch (index) {
            case 0 :
                popup_1.setVisibility(View.VISIBLE);
                break;
            case 1 :
                popup_2.setVisibility(View.VISIBLE);
                break;
            case 2 :
                popup_3.setVisibility(View.VISIBLE);
                break;
        }
    }
}
