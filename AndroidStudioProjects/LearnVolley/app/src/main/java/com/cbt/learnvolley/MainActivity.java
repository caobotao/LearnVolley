package com.cbt.learnvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Volley.newRequestQueue(this);
    }

}