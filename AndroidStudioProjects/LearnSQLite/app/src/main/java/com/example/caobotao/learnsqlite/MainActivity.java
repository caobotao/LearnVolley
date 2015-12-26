package com.example.caobotao.learnsqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //每个程序都有自己的数据库
        //通过openOrCreateDatabase 来打开或创建一个数据库,返回SQLiteDatabase对象
        SQLiteDatabase db = openOrCreateDatabase("user.db",MODE_PRIVATE,null);
        db.execSQL("create table if not exists userTb (" +
                    "_id integer primary key," +
                    "name text not null,age integer not null," +
                    "sex text not null)");
        db.execSQL("insert into userTb (name,age,sex) values ('张三',18,'女')");
        db.execSQL("insert into userTb (name,age,sex) values ('李四',19,'男')");
        db.execSQL("insert into userTb (name,age,sex) values ('王五',20,'女')");

        //Cursor 为查询结果对象
        Cursor queryResult = db.rawQuery("select * from userTb", null);
        if (queryResult != null) {
            while (queryResult.moveToNext()) {
                Log.i("info", "id: " + queryResult.getInt(queryResult.getColumnIndex("_id"))
                        + " 姓名: " + queryResult.getString(queryResult.getColumnIndex("name"))
                        + " 年龄: " + queryResult.getInt(queryResult.getColumnIndex("age"))
                        + " 性别: " + queryResult.getString(queryResult.getColumnIndex("sex")));
            }
            queryResult.close();
        }
        db.close();
    }
}
