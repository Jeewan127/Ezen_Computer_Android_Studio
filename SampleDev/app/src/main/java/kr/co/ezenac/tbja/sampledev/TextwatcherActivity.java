package kr.co.ezenac.tbja.sampledev;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class TextwatcherActivity extends AppCompatActivity {
    EditText et_edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textwatcher);

        et_edittext = findViewById(R.id.et_edittext);

        et_edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("TextWatcher","afterTextChanged : " + s.toString() );
                getUsers(s.toString());
            }
        });
    }

    public void getUsers(String search) {
        String[] colList = new String[]{ContactsContract.Contacts._ID,ContactsContract.Contacts.DISPLAY_NAME_PRIMARY};
        String[] argList = new String[]{"%" + search + "%"};

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
}
