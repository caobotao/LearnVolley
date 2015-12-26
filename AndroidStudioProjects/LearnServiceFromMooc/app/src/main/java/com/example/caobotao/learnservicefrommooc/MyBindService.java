package com.example.caobotao.learnservicefrommooc;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by caobotao on 15/11/8.
 */
public class MyBindService extends Service{
    @Override
    public void onCreate() {
        Log.i("info","BindService--onCreate()");
        super.onCreate();
    }

    public class MyBinder extends Binder {
        public MyBindService getService(){
            return MyBindService.this;
        }
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("info","BindService--onUnbind()");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.i("info","BindService--onDestroy()");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("info", "BindService--onBind()");
        return new MyBinder();
    }
    public void play(){
        Log.i("info","BindService--play()");
    }
    public void pause(){
        Log.i("info","BindService--pause()");
    }
    public void next(){
        Log.i("info","BindService--next()");
    }
    public void last(){
        Log.i("info","BindService--last()");
    }


}
