package com.bawei.gzwprogrogress.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.gzwprogrogress.R;
import com.bawei.gzwprogrogress.bean.NewsDataBean;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

/**
 * @author Dash
 * @date 2017/9/7
 * @description:
 */
public class NewsAdapter extends BaseAdapter {
    Context context;
    List<NewsDataBean.NewslistBean> list;
    public NewsAdapter(Context context, List<NewsDataBean.NewslistBean> list) {
        this.context = context;
        this.list = list;
       ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     * 获取视图类型的数量...也就是有多少种条目类型
     *
     * @return
     */
    @Override
    public int getViewTypeCount() {
        return 4;
    }

    /**
     * 返回当前位置条目视图的类型....返回值是int值
     *
     * @param position ...当前位置
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        if(position%2 == 0){
            return 0;
        }else {
            return 1;
        }
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i)){
            case 0:
                VideoHolder holder;
                if (view == null){
                    view = View.inflate(context, R.layout.item_video,null);
                    holder = new VideoHolder();
                    holder.imageView = view.findViewById(R.id.image_video);
                    holder.text_title = view.findViewById(R.id.text_title);
                    view.setTag(holder);
                }else {
                    holder = (VideoHolder) view.getTag();
                }
                ImageLoader.getInstance().displayImage(list.get(i).getPicUrl(),holder.imageView);
                holder.text_title.setText(list.get(i).getTitle());
                break;
            case 1:
                ImageThreeHolder holder1;
                if (view == null){
                    view = View.inflate(context,R.layout.item_three_image,null);
                    holder1 = new ImageThreeHolder();

                    holder1.text_title = view.findViewById(R.id.text_title);

                    view.setTag(holder1);


                }else {
                    holder1 = (ImageThreeHolder) view.getTag();
                }

                holder1.text_title.setText(list.get(i).getTitle());
        }

   return view;

    }
    private class VideoHolder{
        TextView text_title;
        ImageView imageView;
    }

    private class ImageThreeHolder{
        TextView text_title;

    }

}