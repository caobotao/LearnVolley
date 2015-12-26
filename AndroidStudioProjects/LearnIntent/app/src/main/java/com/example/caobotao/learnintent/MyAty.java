package com.example.caobotao.learnintent;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by caobotao on 15-10-1.
 */
public class MyAty extends Activity{
    static String ACTION = "com.example.caobotao.learnintent.intent.action.MyAty";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myaty);
    }
}
