package kr.co.ezenac.tbja.sampledev.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2017-11-30.
 */

public class TestService extends Service {
    private IBinder iBinder = new LocalBinder();

    public class LocalBinder extends Binder {
        public TestService getService() {
            return TestService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("ksj","onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("ksj","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    public void testService() {
        Log.d("ksj","testService");
    }

    public int getValue(int num) {
        return num*10;
    }
}
