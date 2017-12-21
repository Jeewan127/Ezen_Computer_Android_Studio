package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import kr.co.ezenac.tbja.sampledev.customview.ShapeDialog;

public class Exam19Activity extends AppCompatActivity {
    Button btn_show_dialog;
    ImageView img_shape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam19);

        btn_show_dialog = findViewById(R.id.btn_show_dialog);
        img_shape = findViewById(R.id.img_shape);

        btn_show_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShapeDialog dialog = new ShapeDialog(Exam19Activity.this);
                dialog.setCallBacks(new ShapeDialog.CallBacks() {
                    @Override
                    public void onClickImg(int type) {
                        switch (type) {
                            case 0 :
                                img_shape.setBackgroundResource(R.drawable.shape_oval);
                                break;
                            case 1:
                                img_shape.setBackgroundResource(R.drawable.shape_rectangle);
                                break;
                        }
                    }
                });
                dialog.show();
            }
        });
    }
}
