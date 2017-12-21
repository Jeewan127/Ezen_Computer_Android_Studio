package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Exam20Activity extends AppCompatActivity {
    Button btn_left;
    Button btn_right;
    ImageView img_center;
    Button btn_ani_alpha;
    Button btn_ani_tran;
    Button btn_ani_scale;

    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam20);

        btn_left = findViewById(R.id.btn_left);
        btn_right = findViewById(R.id.btn_right);
        img_center = findViewById(R.id.img_center);
        btn_ani_alpha = findViewById(R.id.btn_ani_alpha);
        btn_ani_tran = findViewById(R.id.btn_ani_tran);
        btn_ani_scale = findViewById(R.id.btn_ani_scale);

        btn_ani_alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(
                        Exam20Activity.this,R.anim.alpha);
                img_center.startAnimation(anim);
            }
        });

        btn_ani_tran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(
                        Exam20Activity.this,R.anim.translate);
                img_center.startAnimation(anim);
            }
        });

        btn_ani_scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(
                        Exam20Activity.this,R.anim.scale);
                img_center.startAnimation(anim);
            }
        });

        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index > 0) {
                    index--;

                    chImage(index);
                }
            }
        });

        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index < 4) {
                    index++;

                    chImage(index);
                }
            }
        });

    }

    public void chImage(int index) {
        switch (index) {
            case 0:
                img_center.setBackgroundResource(R.drawable.img_1);
                break;
            case 1:
                img_center.setBackgroundResource(R.drawable.img_2);
                break;
            case 2:
                img_center.setBackgroundResource(R.drawable.img_3);
                break;
            case 3:
                img_center.setBackgroundResource(R.drawable.img_4);
                break;
            case 4:
                img_center.setBackgroundResource(R.drawable.img_5);
                break;
        }
    }
}
