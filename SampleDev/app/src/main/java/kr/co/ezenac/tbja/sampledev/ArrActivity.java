package kr.co.ezenac.tbja.sampledev;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class ArrActivity extends AppCompatActivity {
    Button btn_left;
    Button btn_right;
    Button btn_up;
    Button btn_down;

    ImageView img_0;
    ImageView img_1;
    ImageView img_2;
    ImageView img_3;
    ImageView img_4;
    ImageView img_5;
    ImageView img_6;
    ImageView img_7;
    ImageView img_8;
    ImageView img_9;
    ImageView img_10;
    ImageView img_11;
    ImageView img_12;
    ImageView img_13;
    ImageView img_14;
    ImageView img_15;

    ImageView[][] arr = new ImageView[4][4];

    int y = 0;
    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arr);

        img_0 = findViewById(R.id.img_0);
        img_1 = findViewById(R.id.img_1);
        img_2 = findViewById(R.id.img_2);
        img_3 = findViewById(R.id.img_3);
        img_4 = findViewById(R.id.img_4);
        img_5 = findViewById(R.id.img_5);
        img_6 = findViewById(R.id.img_6);
        img_7 = findViewById(R.id.img_7);
        img_8 = findViewById(R.id.img_8);
        img_9 = findViewById(R.id.img_9);
        img_10 = findViewById(R.id.img_10);
        img_11 = findViewById(R.id.img_11);
        img_12 = findViewById(R.id.img_12);
        img_13 = findViewById(R.id.img_13);
        img_14 = findViewById(R.id.img_14);
        img_15 = findViewById(R.id.img_15);

        arr[0][0] = img_0;
        arr[0][1] = img_1;
        arr[0][2] = img_2;
        arr[0][3] = img_3;
        arr[1][0] = img_4;
        arr[1][1] = img_5;
        arr[1][2] = img_6;
        arr[1][3] = img_7;
        arr[2][0] = img_8;
        arr[2][1] = img_9;
        arr[2][2] = img_10;
        arr[2][3] = img_11;
        arr[3][0] = img_12;
        arr[3][1] = img_13;
        arr[3][2] = img_14;
        arr[3][3] = img_15;

        btn_left = findViewById(R.id.btn_left);
        btn_right = findViewById(R.id.btn_right);
        btn_up = findViewById(R.id.btn_up);
        btn_down = findViewById(R.id.btn_down);

        printMap();

        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (x < 3) {
                    x++;
                    printMap();
                }
            }
        });

        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (x > 0) {
                    x--;
                    printMap();
                }
            }
        });

        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (y > 0) {
                    y--;
                    printMap();
                }
            }
        });

        btn_down.setOnClickListener(new View.OnClickListener() {
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
                arr[i][j].setBackgroundColor(Color.parseColor("#FF0000"));
            }
        }
        arr[y][x].setBackgroundColor(Color.parseColor("#00ff00"));
//        Animation anim = AnimationUtils.loadAnimation(
//                ArrActivity.this,R.anim.alpha);
//        arr[y][x].startAnimation(anim);
    }
}
