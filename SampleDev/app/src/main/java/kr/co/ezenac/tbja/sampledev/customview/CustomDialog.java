package kr.co.ezenac.tbja.sampledev.customview;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import kr.co.ezenac.tbja.sampledev.R;

/**
 * Created by Administrator on 2017-11-28.
 */

public class CustomDialog extends Dialog {
    ImageView img_red;
    ImageView img_blue;
    ImageView img_green;
    ImageView img_yel;

    CallBacks callBacks = null;

    public interface CallBacks{
        void onClickColor(String color);
    }

    public void setCallBacks(CallBacks callBacks) {
        this.callBacks = callBacks;
    }

    public CustomDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.custom_layout);

        img_red = findViewById(R.id.img_red);
        img_blue = findViewById(R.id.img_blue);
        img_green = findViewById(R.id.img_green);
        img_yel = findViewById(R.id.img_yel);

        img_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickColor("#ff0000");
            }
        });

        img_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickColor("#0000ff");
            }
        });

        img_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickColor("#00ff00");
            }
        });

        img_yel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickColor("#ffff00");
            }
        });
    }

    public void clickColor(String color) {
        if (callBacks != null) {
            callBacks.onClickColor(color);
        }
        dismiss();
    }
}
