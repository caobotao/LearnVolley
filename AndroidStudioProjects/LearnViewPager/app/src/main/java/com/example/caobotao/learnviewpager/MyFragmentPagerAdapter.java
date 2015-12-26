package com.example.caobotao.learnviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by caobotao on 15/10/17.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragments ;
    private List<String> titleName;
    public MyFragmentPagerAdapter(FragmentManager fm,List<Fragment> fragments ,List<String> titleName) {
        super(fm);
        this.fragments = fragments;
        this.titleName = titleName;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleName.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
