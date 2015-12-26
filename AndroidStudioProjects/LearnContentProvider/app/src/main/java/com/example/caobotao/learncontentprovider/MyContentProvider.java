package com.example.caobotao.learncontentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by caobotao on 15/11/5.
 */
public class MyContentProvider extends ContentProvider {
    @Override
    //在ContentProvider创建时被调用
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    //根据Uri查询出selection指定的条件所匹配的全部记录,并且可以指定查询哪些列及排序方式
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    /**
     *  返回Uri的MIME类型
     *  如果Uri对应的数据可能包含多条记录,那么MiME类型字符串以 vnd.android.dir/ 开头
     *  如果Uri对应的数据只包含一条记录,那么MiME类型字符串以 vnd.android.cursor.item/ 开头
     */
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    //根据Uri插入ContentValues对应的数据
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    //根据Uri删除selection指定的条件所匹配的全部记录
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    //根据Uri修改selection指定的条件所匹配的全部记录
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
