package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Animation2Activity extends AppCompatActivity {
    Button btn_show_popup;
    Button btn_close;
    RelativeLayout menu_popup;
    TextView text_color;
    Button img_color_1;
    Button img_color_2;
    Button img_color_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation2);

        btn_show_popup = findViewById(R.id.btn_show_popup);
        btn_close = findViewById(R.id.btn_close);
        menu_popup = findViewById(R.id.menu_popup);
        text_color = findViewById(R.id.text_color);
        img_color_1 = findViewById(R.id.img_color_1);
        img_color_2 = findViewById(R.id.img_color_2);
        img_color_3 = findViewById(R.id.img_color_3);

        img_color_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_color.setTextColor(getColor(R.color.color_green));
            }
        });

        img_color_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_color.setTextColor(getColor(R.color.color_blue));
            }
        });
        img_color_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_color.setTextColor(getColor(R.color.color_yellow));
            }
        });

        btn_show_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu_popup.setVisibility(View.VISIBLE);
                Animation anim = AnimationUtils.loadAnimation(
                        Animation2Activity.this,R.anim.menu_popup_up);
                menu_popup.startAnimation(anim);
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(
                        Animation2Activity.this,R.anim.menu_popup_down);
                anim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        menu_popup.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                menu_popup.startAnimation(anim);
            }
        });
    }
}
