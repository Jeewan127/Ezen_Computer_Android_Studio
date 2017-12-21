package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import kr.co.ezenac.tbja.sampledev.adapter.BookAdapter;
import kr.co.ezenac.tbja.sampledev.db.DBManager;

public class Exam17Activity extends AppCompatActivity {
    DBManager dbManager;
    Button btn_insert_data;
    Button btn_delete_data;
    Button btn_update_data;
    EditText et_book_name;
    EditText et_book_price;
    EditText et_delete_id;
    EditText et_update_name;
    EditText et_update_price;
    EditText et_update_id;
    ListView lv_book_list;
    BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam17);

        btn_insert_data = findViewById(R.id.btn_insert_data);
        et_book_name = findViewById(R.id.et_book_name);
        et_book_price = findViewById(R.id.et_book_price);
        btn_delete_data = findViewById(R.id.btn_delete_data);
        et_delete_id = findViewById(R.id.et_delete_id);
        btn_update_data = findViewById(R.id.btn_update_data);
        et_update_name = findViewById(R.id.et_update_name);
        et_update_price = findViewById(R.id.et_update_price);
        et_update_id = findViewById(R.id.et_update_id);
        lv_book_list = findViewById(R.id.lv_book_list);

        dbManager = new DBManager(
                Exam17Activity.this,"BookManager.db",null,1);

        bookAdapter = new BookAdapter(dbManager.getBookList());
        lv_book_list.setAdapter(bookAdapter);

        btn_update_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = et_update_id.getText().toString();
                String name = et_update_name.getText().toString();
                String price = et_update_price.getText().toString();

                dbManager.updateData(id,name,price);
                dbManager.test();
            }
        });

        btn_delete_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = et_delete_id.getText().toString();

                dbManager.deleteData(id);
                dbManager.test();
            }
        });

        btn_insert_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_book_name.getText().toString();
                String price = et_book_price.getText().toString();

                dbManager.insertData(name,price);
                dbManager.test();
            }
        });
    }
}
