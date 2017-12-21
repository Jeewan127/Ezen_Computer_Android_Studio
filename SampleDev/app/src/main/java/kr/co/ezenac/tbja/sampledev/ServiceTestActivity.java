package kr.co.ezenac.tbja.sampledev;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kr.co.ezenac.tbja.sampledev.service.TestService;

public class ServiceTestActivity extends AppCompatActivity {
    Button btn_call_service;
    Button btn_start_service;
    TestService testService;

    Intent intent;
    boolean bound = false;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            TestService.LocalBinder binder = (TestService.LocalBinder) iBinder;

            testService = binder.getService();
            bound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            testService = null;
            bound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);

        btn_call_service = findViewById(R.id.btn_call_service);
        btn_start_service = findViewById(R.id.btn_start_service);

        intent = new Intent(ServiceTestActivity.this, TestService.class);
        startService(intent);
        bindService(intent,connection, Context.BIND_AUTO_CREATE);

        btn_call_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bound) {
                    testService.testService();
                }
            }
        });

        btn_start_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (bound) {
            unbindService(connection);
            stopService(intent);
        }

        super.onDestroy();
    }
}
