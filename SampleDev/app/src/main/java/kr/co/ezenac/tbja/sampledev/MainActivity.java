package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button btn_change;
    TextView text_change;
    TextView text_number_1;
    TextView text_number_2;
    TextView text_number_3;
    Button btn_sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam10_input);

        btn_change = (Button)findViewById(R.id.btn_change);
        text_change = (TextView) findViewById(R.id.text_change);
        text_number_1 = (TextView) findViewById(R.id.text_number_1);
        text_number_2 = (TextView) findViewById(R.id.text_number_2);
        text_number_3 = (TextView) findViewById(R.id.text_number_3);
        btn_sum = (Button)findViewById(R.id.btn_sum);

        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_change.setText(getString(R.string.hello));
            }
        });

        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number1 = text_number_1.getText().toString();
                String number2 = text_number_2.getText().toString();
                Integer res = Integer.parseInt(number1) + Integer.parseInt(number2);
                text_number_3.setText(res.toString());
            }
        });
    }
}
