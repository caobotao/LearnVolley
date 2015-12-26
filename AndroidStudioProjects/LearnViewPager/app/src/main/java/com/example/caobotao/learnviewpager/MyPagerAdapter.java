package com.example.caobotao.learnviewpager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by caobotao on 15-10-17.
 */
public class MyPagerAdapter extends PagerAdapter{
    private List<View> list;
    private List<String> titleList;
    public MyPagerAdapter(List<View> list,List<String> titleList){
        this.titleList = titleList;
        this.list = list;
    }
    //返回页卡的数量
    @Override
    public int getCount() {
        return list.size();
    }
    //View是否来源于对象
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    //实例化一个页卡
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position));
        return list.get(position);
    }
    //销毁一个页卡
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }
    //设置viewpager页卡的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
