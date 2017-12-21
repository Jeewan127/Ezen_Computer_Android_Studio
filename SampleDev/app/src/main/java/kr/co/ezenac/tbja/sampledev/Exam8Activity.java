package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Exam8Activity extends AppCompatActivity {
    EditText et_text;
    TextView text_answer3;
    Button btn_res2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam8);

        et_text = findViewById(R.id.et_text);
        text_answer3 = findViewById(R.id.text_answer3);
        btn_res2 = findViewById(R.id.btn_res2);

        btn_res2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = et_text.getText().toString();

                str = str.replace("1","a");
                str = str.replace("2","b");
                str = str.replace("3","c");
                str = str.replace("4","d");
                str = str.replace("5","e");

                text_answer3.setText(str);
            }
        });

    }
}
