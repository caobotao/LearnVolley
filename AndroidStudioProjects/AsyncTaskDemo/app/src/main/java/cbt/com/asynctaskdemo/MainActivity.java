package cbt.com.asynctaskdemo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView mListView;
    private static String URL = "http://www.imooc.com/api/teacher?type=4&num=30";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.lv_main);
        new NewsAsynTask().execute(URL);
    }

    //将url对应的JSON格式转化为封装好的NewsBean对象
    private List<NewsBean> getJsonData(String url) {
        List<NewsBean> newsList = new ArrayList<>();
        try {
            String jsonString = getJosonString(new URL(url).openStream());
            JSONObject jsonObject;
            NewsBean newsBean;
            jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0;i < jsonArray.length();i++){
                jsonObject = jsonArray.getJSONObject(i);
                newsBean = new NewsBean();
                newsBean.newsIconUrl = jsonObject.getString("picSmall");
                newsBean.newsTitle = jsonObject.getString("name");
                newsBean.newsContent = jsonObject.getString("description");
                newsList.add(newsBean);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return newsList;
    }

    //通过InputStream对象解析网页返回的数据
    private String getJosonString(InputStream is){
        InputStreamReader isr;
        String result = "";
        BufferedReader br;
        try {
            String line = "";
            isr = new InputStreamReader(is,"utf-8");
            br= new BufferedReader(isr);
            while ((line = br.readLine()) != null ){
                result += line;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    //实现网络的异步访问
    class NewsAsynTask extends AsyncTask<String,Void,List<NewsBean>>{

        @Override
        protected List<NewsBean> doInBackground(String... params) {
            return getJsonData(params[0]);
        }

        @Override
        protected void onPostExecute(List<NewsBean> newsBeen) {
            super.onPostExecute(newsBeen);
            NewsAdapter newsAdapter = new NewsAdapter(MainActivity.this,newsBeen);
            mListView.setAdapter(newsAdapter);
        }
    }
}
