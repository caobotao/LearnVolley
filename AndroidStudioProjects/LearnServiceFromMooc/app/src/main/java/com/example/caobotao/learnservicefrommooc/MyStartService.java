package com.example.caobotao.learnservicefrommooc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyStartService extends Service {
    public MyStartService() {
    }

    @Override
    public void onCreate() {
        Log.i("info","Service--onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("info","Service--onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("info", "Service--onDestroy()");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("info","Service--onBind()");
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
