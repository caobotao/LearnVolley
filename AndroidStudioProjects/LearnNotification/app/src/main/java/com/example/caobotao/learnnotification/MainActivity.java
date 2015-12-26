package com.example.caobotao.learnnotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {
    private NotificationManager manager;
    private int notification_ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //取得通知控制类
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        findViewById(R.id.btn_send).setOnClickListener(this);
        findViewById(R.id.btn_cancel).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_send:
                sendNotification();
                break;
            case R.id.btn_cancel:
                manager.cancel(notification_ID);
                break;
        }
    }
    //构造Notification并发送到通知栏
    private void sendNotification(){
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);

        /**************第一步:获取Notification.Builder对象并进行相关设置***************/
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);//设置图标
        builder.setTicker("Hello");//设置手机状态栏的提示
        builder.setWhen(System.currentTimeMillis());//设置时间
        builder.setContentTitle("设置标题栏通知");//设置标题
        builder.setContentText("我来自Notification Demo");
        builder.setContentIntent(pendingIntent);//设置点击后的意图
//        builder.setDefaults(Notification.DEFAULT_SOUND);//设置提示声音
//        builder.setDefaults(Notification.DEFAULT_LIGHTS);//设置指示灯(需要设置权限)
//        builder.setDefaults(Notification.DEFAULT_VIBRATE);//设置震动(需要设置权限)
        builder.setDefaults(Notification.DEFAULT_ALL);//设置提示声音,指示灯(需要设置权限),震动(需要设置权限)
        /**************第一步:获取Notification.Builder对象并进行相关设置***************/

        /**************第二步:获取Notification对象***************/
        Notification notification = builder.build();//4.1及以上使用
//        Notification notification = builder.getNotification();//4.1以下使用
         /**************第二步:获取Notification对象***************/

         /**************第三步:使用NotificationManager对象进行发送***************/
        //发送通知
        manager.notify(notification_ID,notification);
         /**************第三步:使用NotificationManager对象进行发送***************/
    }
}
