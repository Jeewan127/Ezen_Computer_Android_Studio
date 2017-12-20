package com.example.administrator.android_study;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;

public class PermissionActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    Button permission_camera;
    Button permission_contact;
    String[] PERMISSION1 = {Manifest.permission.CAMERA};
    String[] PERMISSION2 = {Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        permission_camera = findViewById(R.id.permission_camera);
        permission_contact = findViewById(R.id.permission_contact);

        permission_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shouldShowRequestPermissionRationale(PERMISSION1[0])) {
                    requestPermissions(PERMISSION1, 0);
                    Log.d("Lee", "camera1");
                } else {
                    requestPermissions(PERMISSION1,0);
                    Log.d("Lee", "camera2");
                }
            }
        });

        permission_contact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PermissionListener permissionlistener = new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        Toast.makeText(PermissionActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                        Toast.makeText(PermissionActivity.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
                    }
                };

                TedPermission.with(PermissionActivity.this)
                        .setPermissionListener(permissionlistener)
                        .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                        .setPermissions(Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS)
                        .check();

                /*if(shouldShowRequestPermissionRationale(PERMISSION2[0])) {
                    requestPermissions(PERMISSION2,1);
                    Log.d("Lee", "contact1");
                } else {
                    requestPermissions(PERMISSION2,1);
                    Log.d("Lee", "contact2");
                }*/
            }
        });
    }

    /*@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 0) {
            for (int i = 0 ; i < permissions.length ; i++) {
                switch (permissions[i]) {
                    case Manifest.permission.READ_CONTACTS:
                    case Manifest.permission.WRITE_CONTACTS:
                        if (grantResults[i] == 0) {
                            Toast.makeText(PermissionActivity.this,"주소록허용",Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(PermissionActivity.this,"주소록거부",Toast.LENGTH_LONG).show();
                        }
                        break;
                }
            }
        } else if (requestCode == 1) {
            for (int i = 0 ; i < permissions.length ; i++) {
                switch (permissions[i]) {
                    case Manifest.permission.CAMERA:
                        if (grantResults[i] == 0) {
                            Toast.makeText(PermissionActivity.this,"카메라허용",Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(PermissionActivity.this,"카메라거부",Toast.LENGTH_LONG).show();
                        }
                        break;
                }
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }*/
}
