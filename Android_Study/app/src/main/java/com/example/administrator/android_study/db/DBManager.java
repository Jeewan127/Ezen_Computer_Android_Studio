package com.example.administrator.android_study.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.administrator.android_study.DbTest01Activity;

/**
 * Created by Administrator on 2017-11-24.
 */

public class DBManager extends SQLiteOpenHelper {

    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) { // 두번째: DB이름, 3번째: null, 4번째: 버전, 1부터 순서대로
        super(context, name, factory, version);
    }

    @Override   // 생성 쿼리문, 딱 한번만 호출
    public void onCreate(SQLiteDatabase db) {
        // 생성할 테이블 쿼리문을 작성해서 스트링형 변수에 저장
        String query="CREATE TABLE Book (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, price INTEGER);";

        db.execSQL(query);  // execSQL: DB명령어를 실행

        db.execSQL("Insert into Book values (null, 'publisher1', 10000);"); // 데이터 추가
        db.execSQL("Insert into Book values (null, 'Java Programming2', 4000);");
        db.execSQL("Insert into Book values (null, 'Java Programming3', 2000);");
    }

    @Override //
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String name, String price) {
        SQLiteDatabase db = getReadableDatabase();

        db.execSQL("Insert into Book values (null, '"+ name +"', "+ Integer.parseInt(price) +");");
    }

    public void test() {
        SQLiteDatabase db = getReadableDatabase();

        // 이터널레이터랑 비슷( bash shell)
        Cursor cursor = db.rawQuery("Select * from Book", null);    // 행행
       while(cursor.moveToNext()) { // DB에 저장된 데이터 출력
            Integer id = cursor.getInt(0);
            String name = cursor.getString(1);
            Integer price = cursor.getInt(2);

            Log.d("test", id + "=" + name +"="+price); // 로그로 확인
        }
    }

}
