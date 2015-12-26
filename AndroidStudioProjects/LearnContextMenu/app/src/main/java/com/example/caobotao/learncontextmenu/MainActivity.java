package com.example.caobotao.learncontextmenu;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showList();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //设置ContextMenu的显示内容
        menu.setHeaderTitle("文件操作");
        menu.setHeaderIcon(R.mipmap.ic_launcher);

        //通过代码添加上下文菜单项
//        menu.add(1, 1, 1, "复制");
//        menu.add(1, 2, 1, "粘贴");
//        menu.add(1, 3, 1, "剪切");
//        menu.add(1,4,1,"重命名");

        //通过xml添加上下文菜单项
        getMenuInflater().inflate(R.menu.main,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_menu_item1:
                Toast.makeText(this,"您点击的是复制",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_menu_item2:
                Toast.makeText(this,"您点击的是粘贴",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_menu_item3:
                Toast.makeText(this,"您点击的是剪切",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_menu_item4:
                Toast.makeText(this,"您点击的是重命名",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    //设置ListView显示内容
    private void showList(){
        //设置ListView
        ListView listView = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getData());
        listView.setAdapter(arrayAdapter);

        this.registerForContextMenu(listView);
    }
    //构造ListvView的数据
    private ArrayList<String> getData(){
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 5; i ++){
            list.add("文件"+(i + 1));
        }
        return list;
    }
}
