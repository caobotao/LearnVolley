package com.example.caobotao.learncontext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by caobotao on 15-10-2.
 */
public class Main2 extends Activity {
    private TextView textView;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        textView.setText("mainActivity共享的数据为： " + getApp().getTextData());
        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((App) getApplicationContext()).setTextData(editText.getText().toString());
                textView.setText("mainActivity共享的数据为： " + editText.getText().toString());
                startActivity(new Intent(Main2.this,MainActivity.class));
            }
        });
    }
    public App getApp(){
        return (App) getApplicationContext();
    }
}
