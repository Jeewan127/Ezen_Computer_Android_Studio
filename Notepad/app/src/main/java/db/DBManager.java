package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017-12-07.
 */

public class DBManager extends SQLiteOpenHelper {
    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE Content (id INTEGER PRIMARY KEY AUTOINCREMENT, title STRING, context STRING);"; // 쿼리문 생성

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertData(String title, String context) {
        SQLiteDatabase db = getReadableDatabase();

        db.execSQL("Insert into Content Values (null," + title + context + ");");
    }
}
