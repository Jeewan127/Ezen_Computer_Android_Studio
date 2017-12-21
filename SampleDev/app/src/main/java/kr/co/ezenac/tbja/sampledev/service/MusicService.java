package kr.co.ezenac.tbja.sampledev.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import kr.co.ezenac.tbja.sampledev.R;

/**
 * Created by Administrator on 2017-12-01.
 */

public class MusicService extends Service {
    private IBinder binder = new MusicBinder();

    private MediaPlayer player;

    public class MusicBinder extends Binder {
        public MusicService getService() {
            return MusicService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(getApplicationContext(), R.raw.song);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        player.release();
    }

    public void startMusic() {
        player.start();
    }

    public void pauseMusic() {
        player.pause();
    }


}
