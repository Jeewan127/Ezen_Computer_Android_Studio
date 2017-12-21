package kr.co.ezenac.tbja.sampledev.customview;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import kr.co.ezenac.tbja.sampledev.R;

/**
 * Created by Administrator on 2017-11-30.
 */

public class ShapeDialog extends Dialog {
    ImageView img_oval;
    ImageView img_rec;

    CallBacks callBacks = null;

    public interface CallBacks {
        void onClickImg(int type);
    }

    public void setCallBacks(CallBacks callBacks) {
        this.callBacks = callBacks;
    }

    public ShapeDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_shape);

        img_oval = findViewById(R.id.img_oval);
        img_rec = findViewById(R.id.img_rec);

        img_oval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callBacks != null) {
                    callBacks.onClickImg(0);
                }
                dismiss();
            }
        });

        img_rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callBacks != null) {
                    callBacks.onClickImg(1);
                }
                dismiss();
            }
        });

    }
}
