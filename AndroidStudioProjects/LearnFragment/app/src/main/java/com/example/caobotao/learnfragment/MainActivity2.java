package com.example.caobotao.learnfragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by caobotao on 15-10-14.
 */
public class MainActivity2 extends Activity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        Button button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.text);
        button.setText("改变");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("textView的值改变了");
            }
        });


    }
}
