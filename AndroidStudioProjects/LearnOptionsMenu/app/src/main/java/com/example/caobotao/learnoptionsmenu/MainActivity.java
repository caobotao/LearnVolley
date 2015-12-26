package com.example.caobotao.learnoptionsmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    //创建菜单项
    public boolean onCreateOptionsMenu(Menu menu) {
        //静态添加菜单项，需要menu的xml文件
        //getMenuInflater().inflate(R.menu.main,menu);

//        MenuItem item = menu.add(1,100,100,"菜单一");
//        item.setIcon(R.mipmap.ic_launcher);// API >= 11 的时候不可用

        //动态添加菜单项
        menu.add(1,100,100,"菜单一");
        menu.add(1,101,100,"菜单二");
        menu.add(1,102,100,"菜单三");
        menu.add(1,103,100,"菜单四");
        menu.add(1,104,100,"菜单五");
        menu.add(1,105,100,"菜单六");
        menu.add(1,106,100,"菜单七");
        menu.add(1,107,100,"菜单八");
        return true;
    }

    @Override
    //添加选中某一项时的事件
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case 100:{
                Log.i("main", "null");
//                Toast.makeText(this,"您点击了菜单一",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);

                item.setIntent(intent);
                break;
            }
            case 101:{
                Toast.makeText(this,"您点击了菜单二",Toast.LENGTH_SHORT).show();
                break;
            }
            case 102:{
                Toast.makeText(this,"您点击了菜单二",Toast.LENGTH_SHORT).show();
                break;
            }
            case 103:{
                Toast.makeText(this,"您点击了菜单三",Toast.LENGTH_SHORT).show();
                break;
            }
            case 104:{
                Toast.makeText(this,"您点击了菜单四",Toast.LENGTH_SHORT).show();
                break;
            }
            case 105:{
                Toast.makeText(this,"您点击了菜单五",Toast.LENGTH_SHORT).show();
                break;
            }
            case 106:{
                Toast.makeText(this,"您点击了菜单六",Toast.LENGTH_SHORT).show();
                break;
            }case 107:{
                Toast.makeText(this,"您点击了菜单七",Toast.LENGTH_SHORT).show();
                break;
            }

        }
        return super.onOptionsItemSelected(item);

    }
}
