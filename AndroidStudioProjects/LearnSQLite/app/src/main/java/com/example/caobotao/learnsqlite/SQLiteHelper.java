package com.example.caobotao.learnsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by caobotao on 15/11/4.
 */
public class SQLiteHelper extends SQLiteOpenHelper{
    public SQLiteHelper(Context context, String name) {
        super(context, name, null, 1);
    }
    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
