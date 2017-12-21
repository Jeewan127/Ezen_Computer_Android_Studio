package kr.co.ezenac.tbja.sampledev;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mp3NotserviceActivity extends AppCompatActivity {
    Button btn_music_start2;
    Button btn_music_stop2;

    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp3_notservice);

        player = MediaPlayer.create(getApplicationContext(), R.raw.song);

        btn_music_start2 = findViewById(R.id.btn_music_start2);
        btn_music_stop2 = findViewById(R.id.btn_music_stop2);

        btn_music_start2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.start();
            }
        });

        btn_music_stop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.pause();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        player.release();
    }
}
