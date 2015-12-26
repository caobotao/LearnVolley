package com.example.caobotao.learnservicefrommooc;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.Future;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button startService;
    private Button stopService;
    private Button bindService;
    private Button unbindService;
    private Button play;
    private Button pause;
    private Button next;
    private Button last;
    private Intent intent1;
    private Intent intent2;
    private ServiceConnection conn;
    private MyBindService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService = (Button) findViewById(R.id.startService);
        stopService = (Button) findViewById(R.id.stopService);
        bindService = (Button) findViewById(R.id.bindService);
        unbindService = (Button) findViewById(R.id.unbindService);
        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        next = (Button) findViewById(R.id.next);
        last = (Button) findViewById(R.id.last);

        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
        bindService.setOnClickListener(this);
        unbindService.setOnClickListener(this);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        next.setOnClickListener(this);
        last.setOnClickListener(this);

        intent1 = new Intent(MainActivity.this,MyStartService.class);
        intent2 = new Intent(MainActivity.this,MyBindService.class);

        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder binder) {
                service = ((MyBindService.MyBinder)binder).getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.startService:
                startService(intent1);
                break;
            case R.id.stopService:
                stopService(intent1);
                break;
            case R.id.bindService:
                bindService(intent2,conn, Service.BIND_AUTO_CREATE);
                break;
            case R.id.unbindService:
                unbindService(conn);
                break;
            case R.id.play:
                service.play();
                break;
            case R.id.pause:
                service.pause();
                break;
            case R.id.next:
                service.next();
                break;
            case R.id.last:
                service.last();
                break;
        }
    }
}
