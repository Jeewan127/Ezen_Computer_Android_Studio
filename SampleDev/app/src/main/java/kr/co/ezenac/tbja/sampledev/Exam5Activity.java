package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Exam5Activity extends AppCompatActivity {
    EditText input_text;
    TextView text_answer2;
    Button btn_res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam5);

        input_text = findViewById(R.id.input_text);
        text_answer2 = findViewById(R.id.text_answer2);
        btn_res = findViewById(R.id.btn_res);

        btn_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = input_text.getText().toString();
                Integer num = Integer.parseInt(number);
                String res = "";

                if (num >= 90) {
                    res = "A";
                } else if (num >= 80 && num < 90) {
                    res = "B";
                } else if (num >= 70 && num < 80) {
                    res = "C";
                } else if (num >= 60 && num < 70) {
                    res = "D";
                } else {
                    res = "과락";
                }

                text_answer2.setText(res);
            }
        });
    }
}
