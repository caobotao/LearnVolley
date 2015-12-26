package com.example.caobotao.activitylifecircle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by caobotao on 15/11/29.
 */
public class Activity2 extends Activity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        textView = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        if (intent != null) {
            Person person = (Person) intent.getSerializableExtra("person");
            textView.setText(person.toString());
        }

    }
}
