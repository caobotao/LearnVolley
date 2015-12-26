package com.example.caobotao.learnfragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends Activity {
    private EditText editText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                MyFragment3 myFragment3 = new MyFragment3();
                Bundle bundle = new Bundle();
                bundle.putString("name",message);
                myFragment3.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.layout,myFragment3);
                fragmentTransaction.commit();
                Toast.makeText(MainActivity3.this,"向Fragment发送数据:"+message,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
