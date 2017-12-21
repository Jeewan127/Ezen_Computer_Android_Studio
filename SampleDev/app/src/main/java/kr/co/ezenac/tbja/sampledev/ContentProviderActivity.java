package kr.co.ezenac.tbja.sampledev;

import android.Manifest;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;

public class ContentProviderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);

        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                String[] colList = new String[]{ContactsContract.Contacts._ID,ContactsContract.Contacts.DISPLAY_NAME_PRIMARY};
                String[] argList = new String[]{"%" + "kim" + "%"};

                Cursor c = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,
                        colList,
                        ContactsContract.Contacts.DISPLAY_NAME_PRIMARY + " Like ?",
                        argList,
                        ContactsContract.Contacts.DISPLAY_NAME_PRIMARY + " asc");
                    while(c.moveToNext()) {
                    String id = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
                    String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY));

                    Cursor phoneCursor = getContentResolver().query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id,
                            null, null);

                    String number = "";
                    if (phoneCursor.moveToNext()) {
                        number = phoneCursor.getString(phoneCursor.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER));
                    }

                    Log.d("ksj" , "name : " + name + " number : " + number);
                    phoneCursor.close();
                }

                c.close();
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                //Toast.makeText(ContentProviderActivity.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }
        };

        TedPermission.with(ContentProviderActivity.this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.READ_CONTACTS,Manifest.permission.WRITE_CONTACTS)
                .check();
    }


}
