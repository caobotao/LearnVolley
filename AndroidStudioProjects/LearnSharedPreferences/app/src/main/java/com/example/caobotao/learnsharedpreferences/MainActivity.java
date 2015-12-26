package com.example.caobotao.learnsharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etUsername,etPassword;
    TextView tvUsername,tvPassword,tvSaveUsername;
    CheckBox cbSaveUsername;
    Button btLogin,btCancel;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        preferences = getSharedPreferences("myPref",MODE_PRIVATE);
        editor = preferences.edit();
        String name = preferences.getString("username", "");
        if(name == null){
            cbSaveUsername.setChecked(false);
        }
        else {
            cbSaveUsername.setChecked(true);
            etUsername.setText(name);
        }
//        editor.putString("name","张三");
//        editor.putInt("age", 22);
//        editor.putLong("time", System.currentTimeMillis());
//        editor.putBoolean("isMarried", false);
//        editor.commit();
//        System.out.println("name: " + preferences.getString("name",""));
//        System.out.println( "age: " + preferences.getInt("age",0));

    }
    private void init(){
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvUsername = (TextView) findViewById(R.id.tvUsername);
        tvPassword = (TextView) findViewById(R.id.tvPassword);
        tvSaveUsername = (TextView) findViewById(R.id.tvRememberUsername);
        cbSaveUsername = (CheckBox) findViewById(R.id.cbRememberUsername);
        btLogin = (Button) findViewById(R.id.btnLogin);
        btCancel = (Button) findViewById(R.id.btnCancel);
        btLogin.setOnClickListener(this);
        btCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = etUsername.getText().toString();
        String pass = etPassword.getText().toString();
        switch (v.getId()){
            case R.id.btnLogin:
                if("admin".equals(name) && "abc123".equals(pass)){
                    if(cbSaveUsername.isChecked()){
                        editor.putString("username",name);
                        editor.commit();
                    }
                    else {
                        editor.remove("username");
                        editor.commit();
                    }
                    Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnCancel:
                break;
        }
    }
}
