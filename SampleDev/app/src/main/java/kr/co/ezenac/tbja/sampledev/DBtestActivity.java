package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import kr.co.ezenac.tbja.sampledev.db.DBManager;

public class DBtestActivity extends AppCompatActivity {
    DBManager dbManager;
    EditText et_book_name;
    EditText et_book_price;
    Button btn_insert_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbtest);

        et_book_name = findViewById(R.id.et_book_name);
        et_book_price = findViewById(R.id.et_book_price);
        btn_insert_book = findViewById(R.id.btn_insert_book);

        dbManager = new DBManager(
                DBtestActivity.this,"BookManager.db",null,1);

        btn_insert_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_book_name.getText().toString();
                String price = et_book_price.getText().toString();

                dbManager.insertData(name,price);
                dbManager.test();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
