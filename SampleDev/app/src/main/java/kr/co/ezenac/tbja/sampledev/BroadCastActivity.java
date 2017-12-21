package kr.co.ezenac.tbja.sampledev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BroadCastActivity extends AppCompatActivity {
    public static String ACTION = "kr.co.ezen.sampleApp.CUSTOM_ACTION";
    Button btn_send_broad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);

        btn_send_broad = findViewById(R.id.btn_send_broad);
        btn_send_broad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ACTION);
                sendBroadcast(intent);
            }
        });
    }
}
