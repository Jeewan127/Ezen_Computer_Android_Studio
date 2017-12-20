package com.example.administrator.android_study.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.android_study.R;

public class BaseballActivity extends AppCompatActivity {

    //멤버 변수
    TextView baseball_playCount;
    TextView baseball_first_random;
    TextView baseball_second_random;
    TextView baseball_third_random;
    EditText baseball_first_number;
    EditText baseball_second_number;
    EditText baseball_third_number;
    TextView baseball_strike;
    TextView baseball_ball;
    TextView baseball_out;
    Button baseball_check;
    Button baseball_restart;

    Integer random [] = new Integer[3];
    Integer number [] = new Integer[3];
    Integer count = 0;
    Integer strike = 0;
    Integer ball = 0;
    Integer out = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseball);

        baseball_playCount = findViewById(R.id.baseball_playCount);
        baseball_first_random = findViewById(R.id.baseball_first_random);
        baseball_second_random = findViewById(R.id.baseball_second_random);
        baseball_third_random = findViewById(R.id.baseball_third_random);
        baseball_first_number = findViewById(R.id.baseball_first_number);
        baseball_second_number = findViewById(R.id.baseball_second_number);
        baseball_third_number = findViewById(R.id.baseball_third_number);
        baseball_strike = findViewById(R.id.baseball_strike);
        baseball_ball = findViewById(R.id.baseball_ball);
        baseball_out = findViewById(R.id.baseball_out);
        baseball_check = findViewById(R.id.baseball_check);
        baseball_restart = findViewById(R.id.baseball_restart);

        randomNumber();

        baseball_check.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                number[0] = Integer.parseInt(baseball_first_number.getText().toString());
                number[1] = Integer.parseInt(baseball_second_number.getText().toString());
                number[2] = Integer.parseInt(baseball_third_number.getText().toString());

                if(numberOverlap(number[0], number[1], number[2])) {
                    strike = strikeCount();
                    ball = ballCount();
                    out = outCount();

                    count++;

                    if(out == 3) {
                        printLastResult();
                        Toast.makeText(getApplicationContext(), "게임이 끝났습니다.", Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), "다시하기를 누르세요", Toast.LENGTH_LONG).show();
                        baseball_check.setEnabled(false);
                    } else {
                        printResult();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "중복된 숫자를 입력하였습니다.", Toast.LENGTH_LONG).show();
                }
                initialization();
            }
        });

        baseball_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initialization();
                out = 0;
                randomNumber();
                count = 0;

                baseball_first_random.setText("?");
                baseball_second_random.setText("?");
                baseball_third_random.setText("?");
                baseball_strike.setText(strike.toString()+"Strike");
                baseball_ball.setText(ball.toString()+"Ball");
                baseball_out.setText(out.toString()+"out");
                baseball_playCount.setText(count.toString());

                baseball_check.setEnabled(true);
            }
        });
    }
    public void randomNumber() {
        // 3개의 랜덤한 숫자 중복되지 않게 생성
        for(int i=0; i<random.length; i++) {
            random[i] = (int)(Math.random()*10);
            for(int k=0; k<i; k++) {
                if(random[i] == random[k]) {
                    i--;
                }
            }
        }
    }

    public void initialization() {
        strike = 0;
        ball = 0;
    }
    public boolean numberOverlap(Integer first, Integer second, Integer third) {
        boolean overlap = true;
        if(first == second || first == third || second == third) {
            overlap = false;
        }
        return overlap;
    }

    public void printLastResult() {
        baseball_first_random.setText(random[0].toString());
        baseball_second_random.setText(random[1].toString());
        baseball_third_random.setText(random[2].toString());
        baseball_strike.setText(strike.toString()+"Strike");
        baseball_ball.setText(ball.toString()+"Ball");
        baseball_out.setText(out.toString()+"Out");
        baseball_playCount.setText(count.toString());
    }

    public void printResult() {
        baseball_strike.setText(strike.toString()+"Strike");
        baseball_ball.setText(ball.toString()+"Ball");
        baseball_out.setText(out.toString()+"Out");
        baseball_playCount.setText(count.toString());
    }

    public Integer strikeCount() {
        if(number[0] == random[0]) { strike ++; }
        if(number[1] == random[1]) { strike ++; }
        if(number[2] == random[2]) { strike ++; }
        return strike;
    }

    public Integer ballCount() {
        if(number[0] == random[1] || number[0] == random[2]) { ball ++; }
        if(number[1] == random[0] || number[1] == random[2]) { ball ++; }
        if(number[2] == random[0] || number[2] == random[1]) { ball ++; }
        return ball;
    }

    public Integer outCount() {
        if(strike == 3) {
            out++;
            if(out != 3) {
            randomNumber(); }
        }
        return out;
    }

}
