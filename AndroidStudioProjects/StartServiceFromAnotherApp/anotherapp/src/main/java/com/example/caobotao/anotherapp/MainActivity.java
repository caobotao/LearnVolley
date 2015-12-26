package com.example.caobotao.anotherapp;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.caobotao.startservicefromanotherapp.IAppServiceRemoteBinder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {
    private Intent intent;
    private EditText etInput;
    private IAppServiceRemoteBinder binder = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInput = (EditText) findViewById(R.id.etInput);
        intent = new Intent();
        intent.setComponent(new ComponentName("com.example.caobotao.startservicefromanotherapp","com.example.caobotao.startservicefromanotherapp.AppService"));
        findViewById(R.id.btnStartAppService).setOnClickListener(this);
        findViewById(R.id.btnStopAppService).setOnClickListener(this);
        findViewById(R.id.btnBindAppService).setOnClickListener(this);
        findViewById(R.id.btnUnbindAppService).setOnClickListener(this);
        findViewById(R.id.btnSync).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStartAppService:
                startService(intent);
                break;
            case R.id.btnStopAppService:
                stopService(intent);
                break;
            case R.id.btnBindAppService:
                bindService(intent,this,BIND_AUTO_CREATE);
                break;
            case R.id.btnUnbindAppService:
                unbindService(this  );
                binder = null;
                break;
            case R.id.btnSync:
                if (binder != null){
                    try {
                        binder.setData(etInput.getText().toString());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;

        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("bind service");
        System.out.println(service);
        binder = IAppServiceRemoteBinder.Stub.asInterface(service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
