package com.example.caobotao.learnfile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.etWrite);
        btn = (Button) findViewById(R.id.btnWriteAndRead);
        tv = (TextView) findViewById(R.id.tvRead);
        btn.setOnClickListener(this);
    }
    //保存文件内容
    public void writeToFile(String content){
        try {
            FileOutputStream fileOutputStream = openFileOutput("a.txt", MODE_PRIVATE);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //读取文件内容
    public String readFromFile(){
        String content = null;
        try {
            FileInputStream fis = openFileInput("a.txt");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while( (len = fis.read(buffer)) != -1 ){
                baos.write(buffer,0,len);
            }
            content = baos.toString();
            fis.close();
            baos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    @Override
    public void onClick(View v) {
        writeToFile(et.getText().toString());
        tv.setText(readFromFile());
    }
}
