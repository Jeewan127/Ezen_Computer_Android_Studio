package kr.co.ezenac.tbja.sampledev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Exam15_2Activity extends AppCompatActivity {
    EditText et_text_2;
    Button btn_send_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam15_2);

        et_text_2 = findViewById(R.id.et_text_2);
        btn_send_2 = findViewById(R.id.btn_send_2);

        btn_send_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = et_text_2.getText().toString();

                Intent intent = getIntent();
                intent.putExtra("text",text);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
