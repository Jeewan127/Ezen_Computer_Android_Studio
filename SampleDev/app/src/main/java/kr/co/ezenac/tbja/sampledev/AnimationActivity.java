package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {
    Button btn_alpha;
    Button btn_rotation;
    Button btn_scale;
    Button btn_translate;
    Button btn_set;
    ImageView menu_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        btn_alpha = findViewById(R.id.btn_alpha);
        btn_rotation = findViewById(R.id.btn_rotation);
        btn_scale = findViewById(R.id.btn_scale);
        btn_translate = findViewById(R.id.btn_translate);
        menu_view = findViewById(R.id.menu_view);
        btn_set = findViewById(R.id.btn_set);

        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(
                        AnimationActivity.this,R.anim.set);
                anim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Log.d("ksj","onAnimationStart");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Log.d("ksj","onAnimationEnd");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        Log.d("ksj","onAnimationRepeat");
                    }
                });
                btn_set.startAnimation(anim);
            }
        });

        btn_translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(
                        AnimationActivity.this,R.anim.translate);
                menu_view.startAnimation(anim);
            }
        });

        btn_scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(
                        AnimationActivity.this,R.anim.scale);
                btn_scale.startAnimation(anim);
            }
        });

        btn_rotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(AnimationActivity.this,R.anim.rotation);
                btn_rotation.startAnimation(anim);
            }
        });

        btn_alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(AnimationActivity.this,R.anim.alpha);
                btn_alpha.startAnimation(anim);
            }
        });
    }
}
