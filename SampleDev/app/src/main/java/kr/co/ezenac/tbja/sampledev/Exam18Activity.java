package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import kr.co.ezenac.tbja.sampledev.customview.MemberInputDialog;

public class Exam18Activity extends AppCompatActivity {
    Button btn_load_member;
    TextView txt_name;
    TextView txt_age;
    TextView txt_addr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam18);

        btn_load_member = findViewById(R.id.btn_load_member);
        txt_name = findViewById(R.id.txt_name);
        txt_age = findViewById(R.id.txt_age);
        txt_addr = findViewById(R.id.txt_addr);

        btn_load_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MemberInputDialog dialog = new MemberInputDialog(Exam18Activity.this);
                dialog.setCallbacks(new MemberInputDialog.Callbacks() {
                    @Override
                    public void onClickSend(String name, String age, String addr) {
                        txt_name.setText(name);
                        txt_age.setText(age);
                        txt_addr.setText(addr);
                    }
                });
                dialog.show();
            }
        });
    }
}
