package cbt.com.asynctaskdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.LruCache;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by caobotao on 15/12/14.
 */
public class ImageLoader {
    private ImageView mImageView ;
    private String mUrl;
    //创建LruCache对象,LruCache是基于LinkedHashMap进行实现的
    private LruCache<String,Bitmap> mCaches;

    public ImageLoader(){
        //获取最大可用内存
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheSize = maxMemory / 4;
        mCaches = new LruCache<String,Bitmap>(cacheSize){
            //在每次存入缓存的时候调用
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount();
            }
        };
    }

    //添加到缓存
    public void addBitmapToCache(String url,Bitmap bitmap){
        if (getBitmapFromCache(url) == null) {
            mCaches.put(url,bitmap);
        }
    }

    //从缓存中获取数据
    public Bitmap getBitmapFromCache(String url){
        return mCaches.get(url);
    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (mImageView.getTag().equals(mUrl)) {
                mImageView.setImageBitmap((Bitmap) msg.obj);
            }
        }
    };

    /*方法一:使用Thread加载图片*/
    public void showImageViewByThread(ImageView imageView, final String url){
        mImageView = imageView;
        mUrl = url;
        new Thread(){
            @Override
            public void run() {
                super.run();
                Bitmap bitmap = getBitmapFromUrl(url);
                Message message = Message.obtain();
                message.obj = bitmap;
                mHandler.sendMessage(message);
            }
        }.start();
    }
    /*方法一:使用Thread加载图片*/

    /*方法二:使用AsyncTask加载图片*/
    public void showImageByAsyncTask(ImageView imageView,String url){
        //试图从缓存中取出图片
        Bitmap bitmap = getBitmapFromCache(url);
        //如果缓存中没有对应的图片,则直接加载
        if (bitmap == null) {
            new NewsAsyncTask(imageView,url).execute(url);
        }else {//如果缓存中有对应的图片,则从缓存中读取即可
            imageView.setImageBitmap(bitmap);
        }

    }
    private class NewsAsyncTask extends AsyncTask<String,Void,Bitmap>{
        private ImageView mImageView;
        private String mUrl;
        public NewsAsyncTask(ImageView imageView,String url){
            mImageView = imageView;
            mUrl = url;
        }
        @Override
        protected Bitmap doInBackground(String... params) {
            String url = params[0];
            //从网络获取图片
            Bitmap bitmap = getBitmapFromUrl(url);
            if (bitmap != null) {
                //将图片存入缓存
                addBitmapToCache(url,bitmap);
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (mImageView.getTag().equals(mUrl)) {
                mImageView.setImageBitmap(bitmap);
            }
        }
    }
    /*方法二:使用AsyncTask加载图片*/

    public Bitmap getBitmapFromUrl(String imageUrl){
        Bitmap bitmap;
        InputStream is;
        URL url;
        try {
            url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            is = new BufferedInputStream(connection.getInputStream());
            bitmap = BitmapFactory.decodeStream(is);
            connection.disconnect();
            is.close();
            return bitmap;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
