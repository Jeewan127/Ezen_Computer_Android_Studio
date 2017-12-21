package kr.co.ezenac.tbja.sampledev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Act1Activity extends AppCompatActivity {
    Button btn_start_act;
    TextView text_rec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act1);

        btn_start_act = findViewById(R.id.btn_start_act);
        text_rec = findViewById(R.id.text_rec);

        btn_start_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Act1Activity.this,Act2Activity.class);
                //startActivity(intent);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String text = data.getStringExtra("etText");
                text_rec.setText(text);
            }
        }
    }
}
