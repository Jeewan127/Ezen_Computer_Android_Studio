package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Exam12Activity extends AppCompatActivity {
    RelativeLayout left_popup;
    Button btn_show_left_popup;
    boolean popup_open = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam12);

        left_popup = findViewById(R.id.left_popup);
        btn_show_left_popup = findViewById(R.id.btn_show_left_popup);

        btn_show_left_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!popup_open) {
                    left_popup.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation(
                            Exam12Activity.this, R.anim.menu_popup_left_to_right);
                    left_popup.startAnimation(anim);
                    popup_open = true;
                    btn_show_left_popup.setText("close popup");
                } else {
                    Animation anim = AnimationUtils.loadAnimation(
                            Exam12Activity.this, R.anim.menu_popup_right_to_left);
                    anim.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            btn_show_left_popup.setText("show popup");
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            left_popup.setVisibility(View.GONE);
                            popup_open = false;

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
