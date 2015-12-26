package com.example.caobotao.learngallery;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener ,ViewSwitcher.ViewFactory{
    private int[] pics = {
            R.drawable.item1,R.drawable.item2,R.drawable.item3,R.drawable.item4,
            R.drawable.item5,R.drawable.item6,R.drawable.item7,R.drawable.item8,
            R.drawable.item9,R.drawable.item10,R.drawable.item11,R.drawable.item12
    };
    private Gallery gallery;
    private ImageAdapter imageAdapter;
    private ImageSwitcher imageSwitcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageSwitcher = (ImageSwitcher)findViewById(R.id.is);
        imageAdapter = new ImageAdapter(pics,this);
        gallery = (Gallery) findViewById(R.id.gallery);
        gallery.setAdapter(imageAdapter);
        gallery.setOnItemSelectedListener(this);
        imageSwitcher.setFactory(this);
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        imageSwitcher.setBackgroundResource(pics[position % pics.length]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public View makeView() {
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

        return imageView;
    }
}
