package kr.co.ezenac.tbja.sampledev.customview;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import kr.co.ezenac.tbja.sampledev.R;

/**
 * Created by Administrator on 2017-11-30.
 */

public class MemberInputDialog extends Dialog {
    Button btn_dialog_send;
    EditText et_name;
    EditText et_age;
    EditText et_addr;

    Callbacks callbacks;

    public interface Callbacks {
        void onClickSend(String name,String age,String addr);
    }

    public void setCallbacks(Callbacks callbacks) {
        this.callbacks = callbacks;
    }

    public MemberInputDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_member_input);
        btn_dialog_send = findViewById(R.id.btn_dialog_send);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_addr = findViewById(R.id.et_addr);

        btn_dialog_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_name.getText().toString();
                String age = et_age.getText().toString();
                String addr = et_addr.getText().toString();

                if (callbacks != null) {
                    callbacks.onClickSend(name,age,addr);
                }

                dismiss();
            }
        });
    }
}
