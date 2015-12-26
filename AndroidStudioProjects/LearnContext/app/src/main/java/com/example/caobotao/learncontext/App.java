package com.example.caobotao.learncontext;

import android.app.Application;

/**
 * Created by caobotao on 15-10-2.
 */
public class App extends Application {
    private String textData = "default";

    public String getTextData() {
        return textData;
    }

    public void setTextData(String textData) {
        this.textData = textData;
    }
}
