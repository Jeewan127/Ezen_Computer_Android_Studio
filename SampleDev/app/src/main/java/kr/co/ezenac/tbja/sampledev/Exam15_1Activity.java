package kr.co.ezenac.tbja.sampledev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Exam15_1Activity extends AppCompatActivity {
    EditText et_text_1;
    Button btn_send_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam15_1);
        et_text_1 = findViewById(R.id.et_text_1);
        btn_send_1 = findViewById(R.id.btn_send_1);

        btn_send_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = et_text_1.getText().toString();
                Intent intent = getIntent();
                intent.putExtra("str",str);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
