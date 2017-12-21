package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Exam10Activity extends AppCompatActivity {
    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    int minePos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam10);
        minePos = (int)(Math.random()*9);

        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isMine(0)) {
                    btn_0.setText("X");
                } else {
                    btn_0.setText("O");
                }
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isMine(1)) {
                    btn_1.setText("X");
                } else {
                    btn_1.setText("O");
                }
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isMine(2)) {
                    btn_2.setText("X");
                } else {
                    btn_2.setText("O");
                }
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isMine(3)) {
                    btn_3.setText("X");
                } else {
                    btn_3.setText("O");
                }
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isMine(4)) {
                    btn_4.setText("X");
                } else {
                    btn_4.setText("O");
                }
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isMine(5)) {
                    btn_5.setText("X");
                } else {
                    btn_5.setText("O");
                }
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isMine(6)) {
                    btn_6.setText("X");
                } else {
                    btn_6.setText("O");
                }
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isMine(7)) {
                    btn_7.setText("X");
                } else {
                    btn_7.setText("O");
                }
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isMine(8)) {
                    btn_8.setText("X");
                } else {
                    btn_8.setText("O");
                }
            }
        });


        /*
        for (int i = 0 ; i < btn.length ; i++) {
            tmpI = i;
            btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (minPos == tmpI) {
                        btn[tmpI].setText("X");
                    } else {
                        btn[tmpI].setText("O");
                    }
                }
            });
        }
        */
    }

    public boolean isMine(int pos) {
        if (minePos == pos) {
            return true;
        }

        return false;
    }
}
