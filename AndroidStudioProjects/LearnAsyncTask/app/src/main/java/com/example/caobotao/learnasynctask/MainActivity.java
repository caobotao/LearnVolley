package com.example.caobotao.learnasynctask;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button btn_image;
    private Button btn_progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_image = (Button) findViewById(R.id.btn_image);
        btn_progress = (Button) findViewById(R.id.btn_progress);

        btn_image.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ImageActivity.class));
            }
        });

        btn_progress.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ProgressActivity.class));
            }
        });
    }
}
