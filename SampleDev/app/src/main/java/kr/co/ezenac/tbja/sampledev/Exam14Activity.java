package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Exam14Activity extends AppCompatActivity {
    Button btn_popup;
    RelativeLayout popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam14);

        btn_popup = findViewById(R.id.btn_popup);
        popup = findViewById(R.id.popup);

        btn_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popup.getVisibility() == View.GONE) {
                    popup.setVisibility(View.VISIBLE);
                } else {
                    popup.setVisibility(View.GONE);
                }
            }
        });
    }
}
