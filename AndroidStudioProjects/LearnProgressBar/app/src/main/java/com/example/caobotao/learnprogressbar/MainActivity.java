package com.example.caobotao.learnprogressbar;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{
    private ProgressBar progressBar;
    private Button btnAdd;
    private Button btnReduce;
    private Button btnReset;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        //启用窗口特征，启用带进度和不带进度的进度条
//        requestWindowFeature(Window.FEATURE_PROGRESS);
//        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
//
//        //显示两种进度条
//        setProgressBarVisibility(true);
//        setProgressBarIndeterminateVisibility(false);
//        //Max = 10000
//        setProgress(9999);
        init();
    }

    private void init(){
        progressBar = (ProgressBar) findViewById(R.id.horiz);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnReduce = (Button) findViewById(R.id.btnReduce);
        btnReset = (Button) findViewById(R.id.btnReset);
        textView = (TextView) findViewById(R.id.tvReset);
        //获取第一进度条的进度
        int first = progressBar.getProgress();
        //获取第二进度条的进度
        int second = progressBar.getSecondaryProgress();
        //获取最大的进度
        int max = progressBar.getMax();
        btnAdd.setOnClickListener(this);
        btnReduce.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        textView.setText("第一进度百分比:" + (int)(first/(float)max*100) + "% \n" +
                         "第二进度百分比:" + (int)(second/(float)max*100) + "%");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:
                //增加第一进度和第二进度10个刻度
                progressBar.incrementProgressBy(10);
                progressBar.incrementSecondaryProgressBy(10);
                break;
            case R.id.btnReduce:
                //减少第一进度和第二进度10个刻度
                progressBar.incrementProgressBy(-10);
                progressBar.incrementSecondaryProgressBy(-10);
                break;
            case R.id.btnReset:
                //重置到初始状态
                progressBar.setProgress(50);
                progressBar.setSecondaryProgress(80);
                break;
        }
        textView.setText("第一进度百分比:" + (int) (progressBar.getProgress()/(float) progressBar.getMax() * 100)+"% \n" +
                         "第二进度百分比:" + (int) (progressBar.getSecondaryProgress()/(float)progressBar.getMax()*100) + "%");


    }
}
