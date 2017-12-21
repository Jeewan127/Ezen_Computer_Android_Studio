package kr.co.ezenac.tbja.sampledev.db;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import kr.co.ezenac.tbja.sampledev.model.Book;

/**
 * Created by Administrator on 2017-11-24.
 */

public class DBManager extends SQLiteOpenHelper{

    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE Book (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT," +
                "price INTEGER);";

        sqLiteDatabase.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertData(String bookName,String price) {
        SQLiteDatabase db = getReadableDatabase();

        db.execSQL("Insert into Book values (null,'" + bookName + "'," + price + ");");
    }

    public void updateData(String id, String name, String price) {
        SQLiteDatabase db = getReadableDatabase();

        db.execSQL("update Book set name='"+ name +"',price=" + price + " where id=" + id + ";");
    }

    public void deleteData(String id) {
        SQLiteDatabase db = getReadableDatabase();

        db.execSQL("delete from Book where id=" + id);
    }

    public ArrayList<Book> getBookList() {
        ArrayList<Book> list = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from Book;",null);
        while(cursor.moveToNext()) {
            Integer id = cursor.getInt(0);
            String name = cursor.getString(1);
            Integer price = cursor.getInt(2);

            Book tmpBook = new Book(id,name,price);
            list.add(tmpBook);
        }
        cursor.close();

        return list;
    }

    public void test() {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("Select * from Book;",null);
        while(cursor.moveToNext()) {
            Integer id = cursor.getInt(0);
            String name = cursor.getString(1);
            Integer price = cursor.getInt(2);

            Log.d("ksj",id +"=" + name + "=" + price);
        }
        cursor.close();
    }
}
