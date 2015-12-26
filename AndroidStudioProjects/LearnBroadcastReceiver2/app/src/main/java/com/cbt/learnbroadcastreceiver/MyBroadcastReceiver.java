package com.cbt.learnbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.Toast;

/**
 * Created by caobotao on 15/11/7.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        Toast.makeText(context,"从MyBroadcastReceiver接受的广播信息为: " + msg,Toast.LENGTH_SHORT).show();
    }
}
