package kr.co.ezenac.tbja.sampledev;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kr.co.ezenac.tbja.sampledev.service.MusicService;

public class Mp3TestActivity extends AppCompatActivity {
    Button btn_music_start;
    Button btn_music_stop;

    MusicService musicService;
    Intent intent;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MusicService.MusicBinder binder = (MusicService.MusicBinder) iBinder;

            musicService = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            musicService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp3_test);

        btn_music_start = findViewById(R.id.btn_music_start);
        btn_music_stop = findViewById(R.id.btn_music_stop);

        btn_music_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (musicService != null) {
                    musicService.startMusic();
                }
            }
        });

        btn_music_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (musicService != null) {
                    musicService.pauseMusic();
                }
            }
        });

        intent = new Intent(Mp3TestActivity.this,MusicService.class);
        startService(intent);
        bindService(intent,connection,BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (musicService != null) {
            unbindService(connection);
        }
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
        //super.onBackPressed();
    }
}
