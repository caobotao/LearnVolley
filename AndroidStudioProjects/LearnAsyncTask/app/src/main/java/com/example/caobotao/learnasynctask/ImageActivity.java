package com.example.caobotao.learnasynctask;

import android.app.Activity;
import android.graphics.*;
import android.os.*;
import android.view.View;
import android.widget.*;
import java.io.*;
import java.net.*;

/**
 * Created by caobotao on 15/12/2.
 */
public class ImageActivity extends Activity {
    private ImageView imageView ;
    private ProgressBar progressBar ;
    private static String URL = "http://pic3.zhongsou.com/image/38063b6d7defc892894.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image);
        imageView = (ImageView) findViewById(R.id.image);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        //通过调用execute方法开始处理异步任务.相当于线程中的start方法.
        new MyAsyncTask().execute(URL);
    }

    class MyAsyncTask extends AsyncTask<String,Void,Bitmap> {

        //onPreExecute用于异步处理前的操作
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //此处将progressBar设置为可见.
            progressBar.setVisibility(View.VISIBLE);
        }

        //在doInBackground方法中进行异步任务的处理.
        @Override
        protected Bitmap doInBackground(String... params) {
            //获取传进来的参数
            String url = params[0];
            Bitmap bitmap = null;
            URLConnection connection ;
            InputStream is ;
            try {
                connection = new URL(url).openConnection();
                is = connection.getInputStream();
                //为了更清楚的看到加载图片的等待操作,将线程休眠3秒钟.
                Thread.sleep(3000);
                BufferedInputStream bis = new BufferedInputStream(is);
                //通过decodeStream方法解析输入流
                bitmap = BitmapFactory.decodeStream(bis);
                is.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        //onPostExecute用于UI的更新.此方法的参数为doInBackground方法返回的值.
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            //隐藏progressBar
            progressBar.setVisibility(View.GONE);
            //更新imageView
            imageView.setImageBitmap(bitmap);
        }
    }
}
