package com.example.caobotao.learnfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by caobotao on 15-10-15.
 */
public class MyFragment3 extends Fragment {
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, container, false);
        textView = (TextView) view.findViewById(R.id.textOfSend);
        String text = (String) getArguments().get("name");
        textView.setText(text);
        Toast.makeText(getActivity(),"已成功接收到:"+text,Toast.LENGTH_SHORT).show();
        return view;
    }
}
