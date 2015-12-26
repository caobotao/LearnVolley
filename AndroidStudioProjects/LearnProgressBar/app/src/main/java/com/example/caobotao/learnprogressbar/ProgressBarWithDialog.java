package com.example.caobotao.learnprogressbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ProgressBarWithDialog extends Activity {
    private ProgressDialog progressDialog;
    private Button btnDisplayDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_with_dialog);
        btnDisplayDialog = (Button) findViewById(R.id.btnDisplayDialog);
        btnDisplayDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 * 设置页面显示
                 */

                //新建progressDialog对象
                progressDialog = new ProgressDialog(ProgressBarWithDialog.this);
                //设置显示风格
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                //设置标题
                progressDialog.setTitle("慕课网");
                //设置对话框内的文字信息
                progressDialog.setMessage("欢迎来到慕课网");
                //设置图标
                progressDialog.setIcon(R.mipmap.ic_launcher);

                /*
                 * 设置关于progressDialog的一些属性
                 */

                //设置最大进度
                progressDialog.setMax(100);
                //设置初始化进度
                progressDialog.incrementProgressBy(50);
                //进度条是明显显示进度
                progressDialog.setIndeterminate(false);
                //设置一个确定按钮
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ProgressBarWithDialog.this,"欢迎支持慕课网",Toast.LENGTH_SHORT).show();
                    }
                });
                //是否可以通过返回按钮取消对话框
                progressDialog.setCancelable(true);
                //显示progressDialog
                progressDialog.show();
            }
        });
    }
}
