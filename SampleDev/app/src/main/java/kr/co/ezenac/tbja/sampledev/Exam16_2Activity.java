package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Exam16_2Activity extends AppCompatActivity {
    ImageView img_move_1;
    ImageView img_move_2;
    Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam16_2);

        img_move_1 = findViewById(R.id.img_move_1);
        img_move_2 = findViewById(R.id.img_move_2);
        btn_start = findViewById(R.id.btn_start);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (img_move_1.getVisibility() == View.VISIBLE) {
                    Animation anim = AnimationUtils.loadAnimation(
                            Exam16_2Activity.this, R.anim.translate_right);
                    anim.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            img_move_1.setVisibility(View.GONE);
                            img_move_2.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    img_move_1.startAnimation(anim);
                } else {
                    Animation anim = AnimationUtils.loadAnimation(
                            Exam16_2Activity.this, R.anim.translate_left);
                    anim.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            img_move_1.setVisibility(View.VISIBLE);
                            img_move_2.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                    img_move_2.startAnimation(anim);
                }
            }
        });
    }
}
