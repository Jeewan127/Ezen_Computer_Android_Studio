package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ActLifeCycleActivity extends AppCompatActivity {
    TextView text_num;
    Integer number = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_life_cycle);

        text_num = findViewById(R.id.text_num);

        Log.d("ksj","onCreate");
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ksj","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ksj","onResume");

        number++;
        text_num.setText(number.toString());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ksj","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ksj","onDestroy");
    }
}
