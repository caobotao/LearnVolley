package com.example.caobotao.learnspinnerwithimg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Spinner spinner;
    private List<Map<String,Object>> list;
    private SimpleAdapter simpleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        spinner = (Spinner) findViewById(R.id.spinner);
        //1.设置数据源
        list = new ArrayList<Map<String,Object>>();
        getData();
        //2.新建simpleAdapter(数组适配器)
        simpleAdapter = new SimpleAdapter(this,list,android.R.layout.simple_spinner_item,new String[]{"img","text"},new int[]{R.id.imageView,R.id.textView});
        //3.设置下拉列表样式
        simpleAdapter.setDropDownViewResource(R.layout.item);
        //4.spinner加载适配器
        spinner.setAdapter(simpleAdapter);
        //5.设置监听事件
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView.setText("你选择的城市是"+list.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText("您没有选择城市");
            }
        });

    }
    private void getData(){
        String cities[] = new String[]{"北京","上海","广州","深圳"};
        for (int i =0;i < cities.length;i ++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", R.mipmap.ic_launcher);
            map.put("text",cities[i]);
            list.add(map);
        }

    }
}
