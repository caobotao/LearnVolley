package com.example.caobotao.learnlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,AbsListView.OnScrollListener {
    private ListView listView;
    private ArrayAdapter<String> arr_adapter;
    private SimpleAdapter simp_adapter;
    private List<Map<String,Object>> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        listView = (ListView) findViewById(R.id.listView);
        //1.新建一个适配器
        //ArrayAdapter(上下文，当前ListView加载的每一个列表项所对应的布局文件，数据源)
        /**
         * SimpleAdapter(Context context, List<? extends Map<String, ?>> data,
         *               int resource, String[] from, int[] to)
         *
         *   context: 上下文
         *      data: 一个由map组成的List集合
         *  resource: 列表项对应的布局文件
         *      from: Map中的键名
         *        to: 绑定数据视图的ID，与from成对应关系
         */
        //2.适配器加载数据源

        //数组适配器
        String arr_data [] = {"慕课网1","慕课网2","慕课网3","慕课网4"};
        arr_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr_data);

        //数组适配器
        dataList = new ArrayList<Map<String,Object>>();
        simp_adapter = new SimpleAdapter(this,getData(),R.layout.item,new String[]{"pic","text"},new int[]{R.id.pic,R.id.text});
        //3.视图(ListView)加载适配器

        //数组适配器
//        listView.setAdapter(arr_adapter);

        //数组适配器
        listView.setAdapter(simp_adapter);

        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);
    }
    private List<Map<String,Object>> getData(){
        for (int i=1;i<=20;i++){
            Map <String,Object> map =new HashMap<String, Object>();
            map.put("pic",R.mipmap.ic_launcher);
            map.put("text","慕课网"+i);
            dataList.add(map);
        }
        return dataList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String text = listView.getItemAtPosition(position) + "";
        Toast.makeText(this,"position = "+position+" text = "+text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch (scrollState){
            case SCROLL_STATE_FLING:
                Log.i("Main","用户在手指离开屏幕之后，由于用力划一下，视图仍以惯性的作用滑动");
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("pic",R.mipmap.ic_launcher);
                map.put("text","增加项");
                dataList.add(map);
                simp_adapter.notifyDataSetChanged();
                break;
            case SCROLL_STATE_IDLE:
                Log.i("Main","视图已经停止滑动");
                break;
            case SCROLL_STATE_TOUCH_SCROLL:
                Log.i("Main","手指没有离开屏幕，视图仍在滑动");
                break;
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
