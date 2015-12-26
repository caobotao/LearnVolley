package com.example.caobotao.learnfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by caobotao on 15-10-14.
 */
public class MyFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //layout布局文件转化成View对象
        /**
         * resource:Fragment需要加载的布局文件
         * root:加载layout的父viewGroup
         * attachToRoot:false，不返回父viewGroup
         */
        View view = inflater.inflate(R.layout.fragment, container, false);
        TextView textView = (TextView) view.findViewById(R.id.text);
        textView.setText("静态加载Fragment");
        return view;
    }
}
