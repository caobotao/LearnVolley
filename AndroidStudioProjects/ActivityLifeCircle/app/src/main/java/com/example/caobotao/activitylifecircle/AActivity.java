package com.example.caobotao.activitylifecircle;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class AActivity extends Activity {
    private MediaPlayer mediaPlayer;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this,R.raw.song);
        mediaPlayer.start();
        Log.i("info","AActivity onCreate()");
        findViewById(R.id.btnStartBAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                打开浏览器页面
//                startActivity(new Intent(AActivity.this,BActivity.class));
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
//                startActivity(intent);

//                打开相册列表
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                intent.setType("image/*");
//                startActivity(intent);

//                打开发送短信界面
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_SEND);
//                intent.setType("text/plain");
//                intent.putExtra(Intent.EXTRA_TEXT,"Hello World !");
//                startActivity(intent);

//                打开拨号界面
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:110"));
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("info","AActivity onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //如果播放的位置不是0
        if (position != 0){
            mediaPlayer.seekTo(position);//获取播放的位置
            mediaPlayer.start();//开始播放
        }
        Log.i("info","AActivity onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //如果播放器正在播放
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();//暂停播放
            position = mediaPlayer.getCurrentPosition();//获得暂停时播放的位置
        }
        Log.i("info", "AActivity onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("info", "AActivity onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("info","AActivity onDestroy()");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("info","AActivity onRestart()");
    }

}
