package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Exam13Activity extends AppCompatActivity {
    Button btn_popup;
    RelativeLayout left_popup;
    boolean openFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam13);

        btn_popup = findViewById(R.id.btn_popup);
        left_popup = findViewById(R.id.left_popup);

        btn_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!openFlag) {
                    left_popup.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation(
                            Exam13Activity.this, R.anim.menu_popup_left_to_right);
                    anim.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            openFlag = true;
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    left_popup.startAnimation(anim);
                } else {
                    Animation anim = AnimationUtils.loadAnimation(
                            Exam13Activity.this, R.anim.menu_popup_right_to_left);
                    anim.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            left_popup.setVisibility(View.GONE);
                            openFlag = false;
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    left_popup.startAnimation(anim);
                }
            }
        });
    }
}
