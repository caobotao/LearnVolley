package com.cbt.zoomImage;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cbt.view.ZoomImageView;

import org.apache.http.util.EncodingUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MainActivity extends AppCompatActivity implements OnClickListener {
//    private TextView tv;
    private EditText editText;
    private Button btn_findAnswer;
    private Button btn_zero;
    private Button btn_one;
    private Button btn_two;
    private Button btn_three;
    private Button btn_four;
    private Button btn_five;
    private Button btn_six;
    private Button btn_seven;
    private Button btn_eight;
    private Button btn_nine;
    private Button btn_delete;
    private Button btn_clean;
    private ZoomImageView zoomImageView ;
    private List<String> imageNameList;
    private Map<String,String> choiceQuestionMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        tv = (TextView) findViewById(R.id.tv);

        init();
        //异步获取所有选择题及其答案
        getChoiceQuestionAsync();
        //异步加载所有的图片名称
        getImageNameListAsync();

        Intent intent = getIntent();
        int imageId = intent.getIntExtra("imageId",-1);
        if (imageId != -1) {
            zoomImageView.setImageResource(imageId);
        }
    }

    //异步获取所有选择题及其答案
    private void getChoiceQuestionAsync() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                InputStream inputStream = getResources().openRawResource(R.raw.t);
                InputStreamReader inputStreamReader = null;
                try {
                    inputStreamReader = new InputStreamReader(inputStream, "gbk");
                    BufferedReader reader = new BufferedReader(inputStreamReader);
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
//                        int emptyCharIndex = line.charAt(' ');
//                        if (emptyCharIndex != -1) {
//                            Log.i("emptyCharIndex",emptyCharIndex+"");
                        if (line.length() > 0) {
                            String questionNo = line.substring(0, 18);
                            String answer = line.substring(19, line.length());
                            choiceQuestionMap.put(questionNo, answer);
                        }
//                        }
                    }
                    for (Entry<String,String> entry:choiceQuestionMap.entrySet()){
                        System.out.println("题号:" + entry.getKey() + "答案:" + entry.getValue());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    //异步获取所有图片名的列表
    private void getImageNameListAsync() {
        new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... params) {

                Class mipmap = R.mipmap.class;
                Field[] fields = mipmap.getFields();
                for (int i = 0;i < fields.length;i++){
                    imageNameList.add(fields[i].getName());
                }
                return null;
            }
        }.execute();
    }

    //通过图片文件名获取资源id
    public int  getResource(String imageName){
//        Context ctx=getBaseContext();
//        int resId = getResources().getIdentifier(imageName, "mipmap", ctx.getPackageName());
//        //如果没有在"mipmap"下找到imageName,将会返回0
//        return resId;

        Class mipmap = R.mipmap.class;
        try {
            Field field = mipmap.getField(imageName);
            int resId = field.getInt(imageName);
            return resId;
        } catch (NoSuchFieldException e) {//如果没有在"mipmap"下找到imageName,将会返回0
            return 0;
        } catch (IllegalAccessException e) {
            return 0;
        }

    }



    public static String getString(Context context,int resId) {
        InputStream inputStream = context.getResources().openRawResource(resId);

        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "gbk");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuffer sb = new StringBuffer("");
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    //判断是否存在对应的选择题
    public boolean isExistsSuchChoiceQuestion(String questionNo){
        return choiceQuestionMap.containsKey(questionNo);
    }

    //判断是否存在对应的填空题和计算题
    public boolean isExistsSuchImage(String imageName){
        return imageNameList.contains(imageName);
    }

    @Override
    public void onClick(View v) {
        StringBuffer editTextContent = new StringBuffer(editText.getText().toString() + "");
        switch (v.getId()){
            case R.id.btn_findAnswer:
                String questionId = editText.getText().toString().trim();
                if (questionId == null || "".equals(questionId)){
                    Toast.makeText(MainActivity.this,"请输入题号!",Toast.LENGTH_SHORT).show();
                    return;
                }

                int imageId;
                if (!isExistsSuchImage("a" + questionId)){
                    imageId = R.mipmap.nosuchanswer;
                    Toast.makeText(MainActivity.this,"没有找到此题答案",Toast.LENGTH_SHORT).show();
                }
                else {
                    questionId = "a" + questionId;
                    imageId = getResource(questionId);
                }

                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                intent.putExtra("imageId",imageId);
                startActivity(intent);
                break;
            case R.id.btn_zero:
                Log.i("zero","zero");
                editTextContent.append("0");
                break;
            case R.id.btn_one:
                editTextContent.append("1");
                break;
            case R.id.btn_two:
                editTextContent.append("2");
                break;
            case R.id.btn_three:
                editTextContent.append("3");
                break;
            case R.id.btn_four:
                editTextContent.append("4");
                break;
            case R.id.btn_five:
                editTextContent.append("5");
                break;
            case R.id.btn_six:
                editTextContent.append("6");
                break;
            case R.id.btn_seven:
                editTextContent.append("7");
                break;
            case R.id.btn_eight:
                editTextContent.append("8");
                break;
            case R.id.btn_nine:
                editTextContent.append("9");
                break;
            case R.id.btn_delete:
                if (editTextContent.length() > 0) {
                    editTextContent.deleteCharAt(editTextContent.length() - 1);
                }
                break;
            case R.id.btn_clean:
                editTextContent.delete(0,editTextContent.length());
                break;
        }
        editText.setText(editTextContent);
    }
    private void init() {
        imageNameList = new ArrayList<String>();
        choiceQuestionMap = new HashMap<>();

        editText = (EditText) findViewById(R.id.editText);
        editText.setInputType(InputType.TYPE_NULL);
        btn_findAnswer = (Button) findViewById(R.id.btn_findAnswer);
        btn_zero = (Button) findViewById(R.id.btn_zero);
        btn_one = (Button) findViewById(R.id.btn_one);
        btn_two = (Button) findViewById(R.id.btn_two);
        btn_three = (Button) findViewById(R.id.btn_three);
        btn_four = (Button) findViewById(R.id.btn_four);
        btn_five = (Button) findViewById(R.id.btn_five);
        btn_six = (Button) findViewById(R.id.btn_six);
        btn_seven = (Button) findViewById(R.id.btn_seven);
        btn_eight = (Button) findViewById(R.id.btn_eight);
        btn_nine = (Button) findViewById(R.id.btn_nine);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_clean = (Button) findViewById(R.id.btn_clean);

        zoomImageView = (ZoomImageView) findViewById(R.id.zoomImageView);
        btn_findAnswer.setOnClickListener(this);
        btn_zero.setOnClickListener(this);
        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        btn_five.setOnClickListener(this);
        btn_six.setOnClickListener(this);
        btn_seven.setOnClickListener(this);
        btn_eight.setOnClickListener(this);
        btn_nine.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_clean.setOnClickListener(this);

    }
}
