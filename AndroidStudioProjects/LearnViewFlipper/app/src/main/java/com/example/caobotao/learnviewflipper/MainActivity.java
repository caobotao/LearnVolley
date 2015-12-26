package com.example.caobotao.learnviewflipper;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;

public class MainActivity extends Activity {
    private ViewFlipper viewFlipper;
    private int[] resId = {R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4};
    private float startX;
    boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        viewFlipper = (ViewFlipper) findViewById(R.id.flipper);
        //动态导入的方式为ViewFlipper加入子View
        for (int i = 0;i < resId.length; i++){
            viewFlipper.addView(getImageView(resId[i]));
        }
//        //为viewFlipper设置动画效果
//        viewFlipper.setInAnimation(this,R.anim.left_in);
//        viewFlipper.setOutAnimation(this,R.anim.left_out);
//        //设置ViewFlipper视图切换的间隔时间
//        viewFlipper.setFlipInterval(3000);
//        //开始播放
//        viewFlipper.startFlipping();
    }
    public ImageView getImageView(int resId){
        ImageView image = new ImageView(this);
//        image.setImageResource(resId);
        image.setBackgroundResource(resId);
        return image;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            //手指落下
            case MotionEvent.ACTION_DOWN: {
                startX = event.getX();
                break;
            }
            //手指滑动
            case MotionEvent.ACTION_MOVE: {
                //向右滑动(看前一页)
                if (event.getX() - startX  > 100){
                    //为viewFlipper设置动画效果
                    viewFlipper.setInAnimation(this,R.anim.left_in);
                    viewFlipper.setOutAnimation(this,R.anim.left_out);
                    //显示前一页
                    viewFlipper.showPrevious();

                }
                //向左滑动(看后一页)
                if (startX - event.getX() > 100){
                    //为viewFlipper设置动画效果
                    viewFlipper.setInAnimation(this,R.anim.right_in);
                    viewFlipper.setOutAnimation(this,R.anim.right_out);
                    //显示后一页
                    viewFlipper.showNext();
                }
                break;
            }
            //手指离开
            case MotionEvent.ACTION_UP: {
                break;
            }
        }
        return super.onTouchEvent(event);
    }
}
