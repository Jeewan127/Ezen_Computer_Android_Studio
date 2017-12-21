package kr.co.ezenac.tbja.sampledev;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Arr2Activity extends AppCompatActivity {
    ImageView img_t_0;
    ImageView img_t_1;
    ImageView img_t_2;
    ImageView img_t_3;
    ImageView img_t_4;
    ImageView img_t_5;
    ImageView img_t_6;
    ImageView img_t_7;
    ImageView img_t_8;
    ImageView img_t_9;
    ImageView img_t_10;
    ImageView img_t_11;
    ImageView img_t_12;
    ImageView img_t_13;
    ImageView img_t_14;
    ImageView img_t_15;

    Button btn_t_up;
    Button btn_t_left;
    Button btn_t_down;
    Button btn_t_right;

    ImageView[][] arr = new ImageView[4][4];

    int y = 0;
    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arr2);

        img_t_0 = findViewById(R.id.img_t_0);
        img_t_1 = findViewById(R.id.img_t_1);
        img_t_2 = findViewById(R.id.img_t_2);
        img_t_3 = findViewById(R.id.img_t_3);
        img_t_4 = findViewById(R.id.img_t_4);
        img_t_5 = findViewById(R.id.img_t_5);
        img_t_6 = findViewById(R.id.img_t_6);
        img_t_7 = findViewById(R.id.img_t_7);
        img_t_8 = findViewById(R.id.img_t_8);
        img_t_9 = findViewById(R.id.img_t_9);
        img_t_10 = findViewById(R.id.img_t_10);
        img_t_11 = findViewById(R.id.img_t_11);
        img_t_12 = findViewById(R.id.img_t_12);
        img_t_13 = findViewById(R.id.img_t_13);
        img_t_14 = findViewById(R.id.img_t_14);
        img_t_15 = findViewById(R.id.img_t_15);

        btn_t_up = findViewById(R.id.btn_t_up);
        btn_t_left = findViewById(R.id.btn_t_left);
        btn_t_down = findViewById(R.id.btn_t_down);
        btn_t_right = findViewById(R.id.btn_t_right);

        arr[0][0] = img_t_0;
        arr[0][1] = img_t_1;
        arr[0][2] = img_t_2;
        arr[0][3] = img_t_3;
        arr[1][0] = img_t_4;
        arr[1][1] = img_t_5;
        arr[1][2] = img_t_6;
        arr[1][3] = img_t_7;
        arr[2][0] = img_t_8;
        arr[2][1] = img_t_9;
        arr[2][2] = img_t_10;
        arr[2][3] = img_t_11;
        arr[3][0] = img_t_12;
        arr[3][1] = img_t_13;
        arr[3][2] = img_t_14;
        arr[3][3] = img_t_15;

        printMap();

        btn_t_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (x < 3) {
                    x++;
                    printMap();
                }
            }
        });

        btn_t_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (x > 0) {
                    x--;
                    printMap();
                }
            }
        });

        btn_t_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (y > 0) {
                    y--;

                    printMap();
                }
            }
        });

        btn_t_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (y < 3) {
                    y++;

                    printMap();
                }
            }
        });

        for (int i = 0 ; i < arr.length ; i++) {
            for (int j = 0 ; j < arr[i].length ; j++) {
                final int finalI = i;
                final int finalJ = j;
                arr[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        y = finalI;
                        x = finalJ;

                        printMap();
                    }
                });
            }
        }

    }

    public void printMap() {
        for (int i = 0 ; i < arr.length ; i++) {
            for (int j = 0 ; j < arr[i].length ; j++) {
                arr[i][j].setBackgroundColor(Color.parseColor("#ff0000"));
            }
        }
        arr[y][x].setBackgroundColor(Color.parseColor("#00ff00"));

        Animation anim = AnimationUtils.loadAnimation(
                Arr2Activity.this,R.anim.alpha);
        arr[y][x].startAnimation(anim);
    }
}
