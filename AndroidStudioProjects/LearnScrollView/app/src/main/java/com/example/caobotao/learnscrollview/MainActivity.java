package com.example.caobotao.learnscrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private ScrollView scrollView;
    private Button up;
    private Button down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        textView.setText(getResources().getString(R.string.content));
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        up = (Button) findViewById(R.id.up);
        down = (Button) findViewById(R.id.down);
        up.setOnClickListener(this);
        down.setOnClickListener(this);
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    //手指落下
                    case MotionEvent.ACTION_DOWN:{

                        break;
                    }
                    //手指滑动
                    case MotionEvent.ACTION_MOVE:{
                        Log.i("main",scrollView.getY()+"");
                        if (scrollView.getY() <= 0){
                            Log.i("main","滑到了顶部");
                        }
                        if (scrollView.getMeasuredHeight() <= scrollView.getY() + scrollView.getHeight()){
                            textView.append(getResources().getString(R.string.content));
                        }
                        break;
                    }
                    //手指抬起
                    case MotionEvent.ACTION_UP:{
                        break;
                    }
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.up:{
                scrollView.scrollBy(0,30);
                break;
            }
            case R.id.down:{
                scrollView.scrollBy(0,-30);
                break;
            }
        }
    }
}
