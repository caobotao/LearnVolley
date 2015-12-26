package com.example.caobotao.learnsqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.i("abc", "" + Long.MAX_VALUE);
        SQLiteHelper helper = new SQLiteHelper(MainActivity2.this,"stu.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("create table if not exists userTb (" +
                "_id integer primary key," +
                "name text not null,age integer not null," +
                "sex text not null)");
        db.execSQL("insert into userTb (name,age,sex) values ('张三',18,'女')");
    }
}
