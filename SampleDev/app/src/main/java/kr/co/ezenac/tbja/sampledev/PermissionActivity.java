package kr.co.ezenac.tbja.sampledev;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PermissionActivity extends AppCompatActivity
        implements ActivityCompat.OnRequestPermissionsResultCallback{
    Button btn_camera;
    Button btn_contact;

    String[] PERMISSION = {Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS};
    String[] PERMISSION2 = {Manifest.permission.CAMERA};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        btn_camera = findViewById(R.id.btn_camera);
        btn_contact = findViewById(R.id.btn_contact);

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shouldShowRequestPermissionRationale(PERMISSION2[0])) {
                    requestPermissions(PERMISSION2,1);
                } else {
                    requestPermissions(PERMISSION2,1);
                }
            }
        });

        btn_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shouldShowRequestPermissionRationale(PERMISSION[0])
                        || shouldShowRequestPermissionRationale(PERMISSION[1])) {

                    requestPermissions(PERMISSION,0);
                } else {
                    requestPermissions(PERMISSION,0);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 0) {
            for (int i = 0 ; i < permissions.length ; i++) {
                switch (permissions[i]) {
                    case Manifest.permission.READ_CONTACTS:
                    case Manifest.permission.WRITE_CONTACTS:
                        if (grantResults[i] == 0) {
                            Toast.makeText(PermissionActivity.this,"주소록허용",Toast.LENGTH_LONG).show();;
                        } else {
                            Toast.makeText(PermissionActivity.this,"주소록거부",Toast.LENGTH_LONG).show();;
                         }
                        break;
                }
            }
        } else if (requestCode == 1) {
            for (int i = 0 ; i < permissions.length ; i++) {
                switch (permissions[i]) {
                    case Manifest.permission.CAMERA:
                        if (grantResults[i] == 0) {
                            Toast.makeText(PermissionActivity.this,"카메라허용",Toast.LENGTH_LONG).show();;
                        } else {
                            Toast.makeText(PermissionActivity.this,"카메라거부",Toast.LENGTH_LONG).show();;
                        }
                        break;
                }
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
