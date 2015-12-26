package com.example.caobotao.learngesturedetector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView img;
    private GestureDetector myGestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         *  实现手势识别步骤:
         *  ① 创建一个SimpleOnGestureListener的实现类,重写onFling()方法事件,在onFling()中进行手势的业务处理
         *  ② 实例化一个GestureDetector类,将SimpleOnGestureListener的实现类的实例作为其构造方法的参数
         *  ③ 设置要在上面进行手势识别的控件(比如ImageView)的OnTouchListener监听事件,
         *     将MotionEvent转发给GestureDetector对象
         *
         */
        myGestureDetector = new GestureDetector(this,new myGestureListener());
        img = (ImageView) findViewById(R.id.img);
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                myGestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }
    class myGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() - e2.getX() > 50){
                Toast.makeText(MainActivity.this,"从右往左滑动了" + (e1.getX() - e2.getX()) + "像素",Toast.LENGTH_LONG).show();
            }
            else if (e2.getX() - e1.getX() > 50){
                Toast.makeText(MainActivity.this,"从左往右滑动了" + (e2.getX() - e1.getX()) + "像素",Toast.LENGTH_LONG).show();
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}
