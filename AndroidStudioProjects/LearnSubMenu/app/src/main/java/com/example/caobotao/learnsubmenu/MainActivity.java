package com.example.caobotao.learnsubmenu;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //静态添加
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);

        //动态添加
//        SubMenu file = menu.addSubMenu("文件");
//        SubMenu editer =menu.addSubMenu("编辑");
//        file.add(1,1,1,"新建");
//        file.add(1,2,1,"打开");
//        file.add(1,3,1,"保存");
//        file.setHeaderTitle("文件操作");
//        file.setHeaderIcon(R.mipmap.ic_launcher);
//        editer.add(2, 1, 1, "复制");
//        editer.add(2, 2, 1, "粘贴");
//        editer.add(2,3,1,"剪切");
//        editer.add(2,4,1,"重命名");
//        editer.setHeaderTitle("编辑操作");
//        editer.setHeaderIcon(R.mipmap.ic_launcher);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //通过xml的方式处理点击事件
        switch (item.getItemId()){
            case R.id.new_file:
                Toast.makeText(this,"您点击了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.open:
                Toast.makeText(this,"您点击了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.reserve:
                Toast.makeText(this,"您点击了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.copy:
                Toast.makeText(this,"您点击了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.paste:
                Toast.makeText(this,"您点击了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.cut:
                Toast.makeText(this,"您点击了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                break;

        }


        //通过动态的方法处理点击事件
//        if(item.getGroupId() == 1){
//            switch (item.getItemId()){
//                case 1:
//                    Toast.makeText(this,"您点击了"+item.getTitle(),Toast.LENGTH_SHORT).show();
//                    break;
//                case 2:
//                    Toast.makeText(this,"您点击了"+item.getTitle(),Toast.LENGTH_SHORT).show();
//                    break;
//                case 3:
//                    Toast.makeText(this,"您点击了"+item.getTitle(),Toast.LENGTH_SHORT).show();
//                    break;
//            }
//        }
//        else if (item.getGroupId() == 2){
//            switch (item.getItemId()){
//                case 1:
//                    Toast.makeText(this,"您点击了"+item.getTitle(),Toast.LENGTH_SHORT).show();
//                    break;
//                case 2:
//                    Toast.makeText(this,"您点击了"+item.getTitle(),Toast.LENGTH_SHORT).show();
//                    break;
//                case 3:
//                    Toast.makeText(this,"您点击了"+item.getTitle(),Toast.LENGTH_SHORT).show();
//                    break;
//            }
//        }

        return super.onOptionsItemSelected(item);
    }
}
