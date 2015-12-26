package cbt.com.asynctaskdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by caobotao on 15/12/14.
 */
public class NewsAdapter extends BaseAdapter implements OnScrollListener{
    private List<NewsBean> mList;
    private LayoutInflater mInflater;
    private ImageLoader mImageLoader;
    private int mStart;
    private int mEnd;

    public NewsAdapter(Context context,List<NewsBean> data){
        mList = data;
        mInflater = LayoutInflater.from(context);
        mImageLoader = new ImageLoader();
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoder viewHoder = null;
        if (convertView == null) {
            viewHoder = new ViewHoder();
            convertView = mInflater.inflate(R.layout.item_layout,null);
            viewHoder.ivIcon = (ImageView) convertView.findViewById(R.id.iv_icon);
            viewHoder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            viewHoder.tvContent = (TextView) convertView.findViewById(R.id.tv_content);
            convertView.setTag(viewHoder);
        }else {
            viewHoder = (ViewHoder) convertView.getTag();
        }

        viewHoder.ivIcon.setImageResource(R.mipmap.ic_launcher);

        String url = mList.get(position).newsIconUrl;
        viewHoder.ivIcon.setTag(url);

        /*方法一:使用Thread加载图片*/
//        new ImageLoader().showImageViewByThread(viewHoder.ivIcon,url);

        /*方法二:使用AsyncTask加载图片*/
        mImageLoader.showImageByAsyncTask(viewHoder.ivIcon,url);

        viewHoder.tvTitle.setText(mList.get(position).newsTitle);
        viewHoder.tvContent.setText(mList.get(position).newsContent);
        return convertView;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == SCROLL_STATE_IDLE) {
            //加载可见项
        }else {
            //停止任务
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        mStart = firstVisibleItem;
        mEnd = firstVisibleItem + visibleItemCount;
    }

    class ViewHoder{
        TextView tvTitle;
        TextView tvContent;
        ImageView ivIcon;
    }
}
