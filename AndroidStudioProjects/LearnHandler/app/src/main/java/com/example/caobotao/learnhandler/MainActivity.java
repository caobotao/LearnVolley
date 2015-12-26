package com.example.caobotao.learnhandler;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView ;
    private int images[] = new int[]{R.mipmap.image1,R.mipmap.image2,R.mipmap.image3,R.mipmap.image4};
    private int index;
    private Handler handler;
    private MyRunnable myRunnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.image);
        handler = new Handler();
        myRunnable = new MyRunnable();
        new Thread(myRunnable).start();

    }

    class MyRunnable implements Runnable{

        @Override
        public void run() {
            imageView.setImageResource(images[index]);
        }

    }
}
