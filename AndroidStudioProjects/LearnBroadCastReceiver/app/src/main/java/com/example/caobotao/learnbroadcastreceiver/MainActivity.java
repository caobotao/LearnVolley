package com.example.caobotao.learnbroadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MyReceiver myReceiver = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnSendMsg).setOnClickListener(this);
        findViewById(R.id.btnReg).setOnClickListener(this);
        findViewById(R.id.btnUnreg).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSendMsg:
//                Intent intent = new Intent(this,MyReceiver.class);

                Intent intent = new Intent(MyReceiver.ACTION);
                intent.putExtra("data", "jikexueyuan");
//                sendBroadcast(intent);
                sendOrderedBroadcast(intent,null);
                break;
            case R.id.btnReg:
                if (myReceiver == null){
                    myReceiver = new MyReceiver();
                    registerReceiver(myReceiver,new IntentFilter(MyReceiver.ACTION));
                    System.out.println("注册成功");
                }
                break;
            case R.id.btnUnreg:
                if (myReceiver != null){
                    unregisterReceiver(myReceiver);
                    myReceiver = null;
                    System.out.println("注销成功");
                }
                break;
        }
    }
}
