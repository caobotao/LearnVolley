package com.cbt.learnbaseadapter;
import android.content.Context;
import android.nfc.cardemulation.OffHostApduService;
import android.view.*;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
/**
 * Created by caobotao on 15/12/20.
 */
public class MyAdapter extends BaseAdapter{
    private List<ItemBean> mList;//数据源
    private LayoutInflater mInflater;//布局装载器对象

    // 通过构造方法将数据源与数据适配器关联起来
    // context:要使用当前的Adapter的界面对象
    public MyAdapter(Context context, List<ItemBean> list) {
        mList = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    //ListView需要显示的数据数量
    public int getCount() {
        return mList.size();
    }

    @Override
    //指定的索引对应的数据项
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    //指定的索引对应的数据项ID
    public long getItemId(int position) {
        return position;
    }

    @Override
    //返回每一项的显示内容
    public View getView(int position, View convertView, ViewGroup parent) {
//        //将布局文件转化为View对象
//        View view = mInflater.inflate(R.layout.item,null);
//
//        /**
//         * 找到item布局文件中对应的控件
//         */
//        ImageView imageView = (ImageView) view.findViewById(R.id.iv_image);
//        TextView titleTextView = (TextView) view.findViewById(R.id.tv_title);
//        TextView contentTextView = (TextView) view.findViewById(R.id.tv_content);
//
//        //获取相应索引的ItemBean对象
//        ItemBean bean = mList.get(position);
//
//        /**
//         * 设置控件的对应属性值
//         */
//        imageView.setImageResource(bean.itemImageResId);
//        titleTextView.setText(bean.itemTitle);
//        contentTextView.setText(bean.itemContent);
//
//        return view;

//        //如果view未被实例化过，缓存池中没有对应的缓存
//        if (convertView == null) {
//            convertView = mInflater.inflate(R.layout.item,null);
//        }
//        /**
//         * 找到item布局文件中对应的控件
//         */
//        ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_image);
//        TextView titleTextView = (TextView) convertView.findViewById(R.id.tv_title);
//        TextView contentTextView = (TextView) convertView.findViewById(R.id.tv_content);
//
//        //获取相应索引的ItemBean对象
//        ItemBean bean = mList.get(position);
//        /**
//         * 设置控件的对应属性值
//         */
//        imageView.setImageResource(bean.itemImageResId);
//        titleTextView.setText(bean.itemTitle);
//        contentTextView.setText(bean.itemContent);
//        return convertView;

        ViewHolder viewHolder;
        //如果view未被实例化过，缓存池中没有对应的缓存
        if (convertView == null) {
            viewHolder = new ViewHolder();
            // 由于我们只需要将XML转化为View，并不涉及到具体的布局，所以第二个参数通常设置为null
            convertView = mInflater.inflate(R.layout.item, null);

            //对viewHolder的属性进行赋值
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_image);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.content = (TextView) convertView.findViewById(R.id.tv_content);

            //通过setTag将convertView与viewHolder关联
            convertView.setTag(viewHolder);
        }else{//如果缓存池中有对应的view缓存，则直接通过getTag取出viewHolder
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // 取出bean对象
        ItemBean bean = mList.get(position);

        // 设置控件的数据
        viewHolder.imageView.setImageResource(bean.itemImageResId);
        viewHolder.title.setText(bean.itemTitle);
        viewHolder.content.setText(bean.itemContent);

        return convertView;
    }
    // ViewHolder用于缓存控件，三个属性分别对应item布局文件的三个控件
    class ViewHolder{
        public ImageView imageView;
        public TextView title;
        public TextView content;
    }
}


