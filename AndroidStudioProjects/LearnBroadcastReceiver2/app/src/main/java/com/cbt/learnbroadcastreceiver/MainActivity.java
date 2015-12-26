package com.cbt.learnbroadcastreceiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void doClick(View view){
        switch (view.getId()){
            case R.id.sendNormalBroadcast:
                Intent intent = new Intent();
                intent.putExtra("msg","这是一条普通广播");
                intent.setAction("com.cbt.learnbroadcastreceiver");
                sendBroadcast(intent);
                break;
        }
    }
}
