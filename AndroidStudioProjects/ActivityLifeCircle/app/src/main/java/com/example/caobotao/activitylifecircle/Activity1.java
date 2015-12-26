package com.example.caobotao.activitylifecircle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by caobotao on 15/11/29.
 */
public class Activity1 extends Activity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);
        button = (Button) findViewById(R.id.startAnotherActivity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity1.this,Activity2.class);
                Person person = new Person("zhangsan",23,"USST","ShangHai");
                Bundle bundle = new Bundle();
                bundle.putSerializable("person",person);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

}
