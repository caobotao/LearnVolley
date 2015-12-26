package com.example.caobotao.learndialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
    String[] single_list = new String[]{"男","女","女博士","程序员"};
    String[] multi_list = new String[]{"篮球","排球","男生","女生"};
    String[] item_list = new String[]{"项目部","产品部","销售部","行政部"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initEvent();
    }
    //初始化点击事件
    private void initEvent(){
        //确认对话框
        findViewById(R.id.dialog_btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog1();
            }
        });
        //单选对话框
        findViewById(R.id.dialog_btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog2();
            }
        });
        //多选对话框
        findViewById(R.id.dialog_btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog3();
            }
        });
        //列表对话框
        findViewById(R.id.dialog_btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog4();
            }
        });
        //自定义对话框
        findViewById(R.id.dialog_btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog5();
            }
        });
    }

    //显示确认对话框
    private void showDialog1(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("确认对话框");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("确认对话框提示内容");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "点击了确定按钮", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "点击了取消按钮", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    //显示单选对话框
    private void showDialog2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("选择性别");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setSingleChoiceItems(single_list, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = single_list[which];
                Toast.makeText(MainActivity.this, "这个人的性别是" + str, Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    //显示多选对话框
    private void showDialog3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("选择爱好");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMultiChoiceItems(multi_list, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                String str = multi_list[which];
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "你选择了" + str, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "你取消了" + str, Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    //显示列表对话框
    private void showDialog4() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("部门列表");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setItems(item_list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "我的部门是" + item_list[which], Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    //自定义对话框
    private void showDialog5() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.dialog_layout,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("自定义对话框");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
