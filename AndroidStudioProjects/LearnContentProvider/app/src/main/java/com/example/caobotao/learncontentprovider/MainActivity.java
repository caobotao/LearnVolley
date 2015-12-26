package com.example.caobotao.learncontentprovider;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContentResolver cr = getContentResolver();
        Cursor c1 = cr.query(Contacts.CONTENT_URI, new String[]{Contacts._ID, Contacts.DISPLAY_NAME}, null, null, null);
        if(c1 != null) {
            while (c1.moveToNext()) {
                int id = c1.getInt(c1.getColumnIndex("_id"));
                Log.e("info", "id:" + id);
                Log.e("info", "name:" + c1.getString(c1.getColumnIndex("display_name")));

                /****** 根据联系人ID查询联系人号码 ******/
                Cursor c2 = cr.query(Phone.CONTENT_URI, new String[]{Phone.NUMBER, Phone.TYPE}, Phone.CONTACT_ID + "=" + id, null, null);
                if( c2 != null){
                    while(c2.moveToNext()){
                        int type = c2.getInt(c2.getColumnIndex(Phone.TYPE));
                        if(type == Phone.TYPE_HOME) {
                            Log.e("info", "家庭号码: " + c2.getString(c2.getColumnIndex(Phone.NUMBER)));

                        }
                        else if(type == Phone.TYPE_MOBILE){
                            Log.e("info", "手机: " + c2.getString(c2.getColumnIndex(Phone.NUMBER)));
                        }
                    }
                    c2.close();
                }
                /****** 根据联系人ID查询联系人号码 ******/

                /****** 根据联系人ID查询联系人邮箱 ******/
                Cursor c3 = cr.query(Email.CONTENT_URI,new String[]{Email.DATA,Email.TYPE},Email.CONTACT_ID + "=" + id,null,null);
                if(c2 != null){
                    while (c3.moveToNext()){
                        int type = c3.getInt(c3.getColumnIndex(Email.TYPE));
                        if(type == Email.TYPE_HOME){
                            Log.e("info", "家庭邮箱: " + c3.getString(c3.getColumnIndex(Email.DATA)));
                        }
                        else if(type == Email.TYPE_WORK){
                            Log.e("info", "工作邮箱: " + c3.getString(c3.getColumnIndex(Email.DATA)));
                        }
                    }
                    c3.close();
                }
                /****** 根据联系人ID查询联系人邮箱 ******/
            }
            c1.close();
        }
    }
}
