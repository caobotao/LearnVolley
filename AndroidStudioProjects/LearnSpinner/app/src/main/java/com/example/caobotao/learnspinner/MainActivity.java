package com.example.caobotao.learnspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.caobotao.learnspinner.R.id.text;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Spinner spinner;
    private List<String> list;
    private ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textView = (TextView) findViewById(text);
        spinner = (Spinner) findViewById(R.id.spinner);
        //1.设置数据源
        list = new ArrayList<String>();
        list.add("北京");
        list.add("上海");
        list.add("广州");
        list.add("深圳");
        //2.新建ArrayAdapter(数组适配器)
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,list);
        //3.设置下拉列表样式
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //4.spinner加载适配器
        spinner.setAdapter(arrayAdapter);
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
}
