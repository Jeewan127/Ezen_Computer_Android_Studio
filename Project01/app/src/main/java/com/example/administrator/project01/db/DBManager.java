package com.example.administrator.project01.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.administrator.project01.Housekeep;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-11-27.
 */

public class DBManager extends SQLiteOpenHelper {
    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { // db가 생성될때 제일 먼저 실행된는 애
        String query = "CREATE TABLE Content (id INTEGER PRIMARY KEY AUTOINCREMENT, type INTEGER, cost INTEGER, year INTEGER, month INTEGER, day INTEGER);"; // 쿼리문 생성

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertData(int type, int cost, int year, int month, int day) {
        SQLiteDatabase db = getReadableDatabase();

        db.execSQL("Insert into Content Values (null," + type + "," + cost + "," + year + "," + month + "," + day + ");");
    }

    public ArrayList<Housekeep> getCostList(Integer nyear, Integer nmonth, Integer nday) {
        ArrayList<Housekeep> list = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from Content where year=" + nyear + " and month =" +
                nmonth + " and day =" + nday, null);

        while(cursor.moveToNext()) {
            Integer id = cursor.getInt(0);
            Integer type = cursor.getInt(1);
            Integer cost = cursor.getInt(2);
            Integer year = cursor.getInt(3);
            Integer month = cursor.getInt(4);
            Integer day = cursor.getInt(5);

            Housekeep housekeep = new Housekeep(id, type, cost, year, month, day);
            list.add(housekeep);
        }
        return list;
    }

    public void deleteData(int id) {
        SQLiteDatabase db = getReadableDatabase();

        db.execSQL("Delete from Content where id=" + id);
    }
}
