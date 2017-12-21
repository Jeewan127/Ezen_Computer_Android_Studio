package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Exam11Activity extends AppCompatActivity {
    Button btn_popup;
    Button btn_cl_popup;
    RelativeLayout popup_layout;
    Button btn_scale_anim;
    Button btn_trans_anim;
    Button btn_alpha_anim;
    ImageView anim_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam11);

        btn_popup = findViewById(R.id.btn_popup);
        btn_cl_popup = findViewById(R.id.btn_cl_popup);
        popup_layout = findViewById(R.id.popup_layout);
        btn_scale_anim = findViewById(R.id.btn_scale_anim);
        btn_trans_anim = findViewById(R.id.btn_trans_anim);
        btn_alpha_anim = findViewById(R.id.btn_alpha_anim);
        anim_view = findViewById(R.id.anim_view);

        btn_scale_anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(
                        Exam11Activity.this,R.anim.scale);
                anim_view.startAnimation(anim);
            }
        });

        btn_trans_anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(
                        Exam11Activity.this,R.anim.translate);
                anim_view.startAnimation(anim);
            }
        });

        btn_alpha_anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(
                        Exam11Activity.this,R.anim.alpha);
                anim_view.startAnimation(anim);
            }
        });

        btn_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup_layout.setVisibility(View.VISIBLE);
                Animation anim = AnimationUtils.loadAnimation(
                        Exam11Activity.this,R.anim.menu_popup_up);
                popup_layout.startAnimation(anim);
            }
        });

        btn_cl_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(
                        Exam11Activity.this,R.anim.menu_popup_down);
                anim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        popup_layout.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                popup_layout.startAnimation(anim);
            }
        });
    }
}
