package com.example.caobotao.learnviewpager;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends FragmentActivity {
    private ViewPager viewPager;
    private PagerTabStrip pagerTabStrip;
    private List<String> titleList ;
    //以View对像作为数据源
    private List<View> list ;
    //以Fragment作为数据源
    private List<Fragment> fragmentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //通过View对象作为ViewPager对象的数据源
        list = new ArrayList<View>();
        View view1 = View.inflate(this, R.layout.view1, null);
        View view2 = View.inflate(this, R.layout.view2, null);
        View view3 = View.inflate(this, R.layout.view3, null);
        View view4 = View.inflate(this, R.layout.view4, null);
        list.add(view1);
        list.add(view2);
        list.add(view3);
        list.add(view4);

        //通过Fragment对象作为ViewPager对象的数据源
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2());
        fragmentList.add(new Fragment3());
        fragmentList.add(new Fragment4());



        titleList = new ArrayList<String>();
        titleList.add("第一页");
        titleList.add("第二页");
        titleList.add("第三页");
        titleList.add("第四页");

        //初始化viewPager
        viewPager = (ViewPager) findViewById(R.id.pager);

        //创建适配器
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(list,titleList);

        //可以为pageTabStrip设置属性
        pagerTabStrip = (PagerTabStrip) findViewById(R.id.tab);
        pagerTabStrip.setBackgroundColor(Color.YELLOW);
        pagerTabStrip.setTextColor(Color.RED);
        pagerTabStrip.setDrawFullUnderline(false);
        pagerTabStrip.setTabIndicatorColor(Color.GREEN);
        //viewPager加载适配器
//        viewPager.setAdapter(myPagerAdapter);
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),fragmentList,titleList);
        viewPager.setAdapter(myPagerAdapter);
    }

}
