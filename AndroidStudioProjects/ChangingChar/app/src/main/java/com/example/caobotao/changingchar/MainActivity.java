package com.example.caobotao.changingchar;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private boolean running = true;
    private long speed = 1000;
    boolean  disp = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.changingChar);
//        doTheRun();
        final Handler handler = new Handler();

        findViewById(R.id.btnStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = true;
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        while (running) {
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if(!disp) {
                                        textView.setText("" + getARandomChar());
                                    }
                                    else {
                                        textView.setText("");
                                    }
                                }
                            });
                            try {
                                if(!disp) {
                                    sleep(speed);
                                    disp = true;
                                }
                                else {
                                    sleep(200);
                                    disp = false;
                                }

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start();

            }
        });
        findViewById(R.id.btnStop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = false;
            }
        });
        findViewById(R.id.btnSlower).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speed += 500;
            }
        });
        findViewById(R.id.btnFaster).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (speed >= 500) {
                    speed -= 500;
                }
            }
        });
    }

    private void rest() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("");

                    }
                });
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private Character getARandomChar(){
        char ch[] = new char[]{'A','S','D','F','J','K','L',';'};
        int randomNum = (int) (Math.random()*8);
        return ch[randomNum];
    }

}
