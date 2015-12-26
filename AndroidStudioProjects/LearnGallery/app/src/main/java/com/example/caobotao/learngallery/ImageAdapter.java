package com.example.caobotao.learngallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * Created by caobotao on 15/10/18.
 */
public class ImageAdapter extends BaseAdapter {
    private int [] pics ;
    private Context context;
    public ImageAdapter(int[] pics,Context context){
        this.pics = pics;
        this.context = context;
    }
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object getItem(int position) {
        return pics[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView image = new ImageView(context);
        image.setImageResource(pics[position % pics.length]);
        image.setLayoutParams(new Gallery.LayoutParams(200, 150));
        image.setScaleType(ImageView.ScaleType.FIT_XY);
        return image;
    }
}
