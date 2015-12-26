package com.example.caobotao.learnwebview;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private String url = "http://2014.qq.com";
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Uri uri = Uri.parse("http://2014.qq.com/");
//        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
//        startActivity(intent);
        System.out.println("kjhkh");
        System.out.println("kjhkh");
        System.out.println("kjhkh");

        init();
        System.out.println("kjhkh");
    }

    private void init() {
        webView = (WebView) findViewById(R.id.webView);
        //加载本地资源
        //webView.loadUrl("file:///android_asset/NewFile.html");
        //加载web资源
        webView.loadUrl(url);
        //覆盖WebView默认通过第三方或者系统自带的浏览器打开网页的行为，使得网页可以在WebView打开网页
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是True的时候控制网页在WebView中打开，如果为false调用系统浏览器或第三方浏览器打开
                view.loadUrl(url);
                return true;
            }
        });
        //启用支持javascript
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //webView加载页面时优先加载缓存
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) { //newProgress 为1-100的整数
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) { //页面加载完毕，关闭ProgressDialog
                    clossProgressDialog();
                } else { //页面正在加载，打开ProgressDialog
                    openDialog(newProgress);
                }
            }
        });
    }

    private void clossProgressDialog() {
        if(progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    private void openDialog(int newProgress) {
        if(progressDialog == null){
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("正在加载");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setProgress(newProgress);
            progressDialog.show();
        }
        else {
            progressDialog.setProgress(newProgress);
        }
    }
    //改写物理按键<返回>的逻辑

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Toast.makeText(this,webView.getUrl(),Toast.LENGTH_SHORT).show();
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(webView.canGoBack()){
                webView.goBack();
                return true;//返回上一个页面
            }
            else {
                System.exit(0);//退出程序
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
