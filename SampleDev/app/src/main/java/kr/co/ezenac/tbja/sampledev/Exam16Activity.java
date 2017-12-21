package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Exam16Activity extends AppCompatActivity {
    Button btn_start;
    ImageView img_1;
    ImageView img_2;
    boolean moveFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam16);

        btn_start = findViewById(R.id.btn_start);
        img_1 = findViewById(R.id.img_1);
        img_2 = findViewById(R.id.img_2);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!moveFlag) {
                    Animation anim = AnimationUtils.loadAnimation(
                            Exam16Activity.this, R.anim.translate_right);
                    anim.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            img_1.setVisibility(View.GONE);
                            img_2.setVisibility(View.VISIBLE);
                            moveFlag = true;
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    img_1.startAnimation(anim);
                } else {
                    Animation anim = AnimationUtils.loadAnimation(
                            Exam16Activity.this, R.anim.translate_left);
                    anim.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            img_2.setVisibility(View.GONE);
                            img_1.setVisibility(View.VISIBLE);
                            moveFlag = false;
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    img_2.startAnimation(anim);
                }
            }
        });
    }
}
