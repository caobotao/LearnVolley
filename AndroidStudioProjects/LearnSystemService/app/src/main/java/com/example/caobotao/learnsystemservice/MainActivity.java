package com.example.caobotao.learnsystemservice;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button isNetworkConnected;
    private Button isWIFIOpen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_main,null);
        setContentView(view);
        isNetworkConnected = (Button) findViewById(R.id.isNetwordConnected);
        isNetworkConnected.setOnClickListener(this);

        isWIFIOpen = (Button) findViewById(R.id.isWIFIOpen);
        isWIFIOpen.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.isNetwordConnected:
                Toast.makeText(this,
                        "网络" + (isConnected(MainActivity.this) ? "已经":"没有") + "连接",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.isWIFIOpen:
                Log.i("info","11111");
                WifiManager manager = (WifiManager) getSystemService(WIFI_SERVICE);
                Log.i("info",manager.toString());
                if(manager.isWifiEnabled()){
                    Toast.makeText(MainActivity.this,"WIFI已连接",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"WIFI未连接",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    public boolean isConnected(Context context){
        if (context != null) {
            ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
            NetworkInfo workInfo = manager.getActiveNetworkInfo();
            if (workInfo != null){
                return true;
            }
        }
        return false;
    }
}
