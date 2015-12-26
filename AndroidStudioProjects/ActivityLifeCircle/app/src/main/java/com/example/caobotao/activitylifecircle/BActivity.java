package com.example.caobotao.activitylifecircle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class BActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baty);
        Log.i("info","BActivity onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("info","BActivity onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("info","BActivity onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("info","BActivity onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("info","BActivity onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("info", "BActivity onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("info","BActivity onRestart()");
    }

}
