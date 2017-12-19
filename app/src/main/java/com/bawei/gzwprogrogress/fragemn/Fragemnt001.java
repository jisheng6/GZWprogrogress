package com.bawei.gzwprogrogress.fragemn;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.bawei.gzwprogrogress.R;
import com.bawei.gzwprogrogress.adapter.ImagePager;
import com.bawei.gzwprogrogress.adapter.NewsAdapter;
import com.bawei.gzwprogrogress.bean.NewsDataBean;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adminjs on 2017/12/15.
 */

public class Fragemnt001 extends Fragment{
    private LinearLayout linearLayout;
    private List<String> list;
    private List<ImageView> images;
    private ViewPager pager;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0){
                int currentItem = pager.getCurrentItem();
                pager.setCurrentItem(currentItem+1);

                handler.sendEmptyMessageDelayed(0,2000);
            }
        }
    };
    private String path = "http://api.tianapi.com/nba/?key=71e58b5b2f930eaf1f937407acde08fe&num=20";
    private ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragemnt_001,container,false);
        linearLayout = view.findViewById(R.id.linear_layout);
        pager = view.findViewById(R.id.view_page);
        listView = view.findViewById(R.id.listview);
        getData();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list = new ArrayList<>();
        list.add("http://pic4.nipic.com/20091217/3885730_124701000519_2.jpg");
        list.add("http://pic2.ooopic.com/11/98/31/31bOOOPIC12_1024.jpg");
        list.add("http://img.taopic.com/uploads/allimg/120727/201995-120HG1030762.jpg");
        list.add("http://pic2.ooopic.com/12/22/94/30b1OOOPIC5c.jpg");
        list.add("http://img.taopic.com/uploads/allimg/121019/234917-121019231h258.jpg");
        initDoc();
        ImagePager imagePager = new ImagePager(getActivity(), list, handler);
        //
        pager.setAdapter(imagePager);

        //设置ViewPager初始展示的位置
        pager.setCurrentItem(list.size() * 10000);


        //发送延时消息
        handler.sendEmptyMessageDelayed(0, 2000);


        //viewPager页面改变的监听事件
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //如果选中了这一页,,,当前小圆点红色,,,否则绿色
                for (int i = 0; i < images.size(); i++) {
                    if (i == position % images.size()) {
                        images.get(i).setImageResource(R.drawable.doc_select);
                    } else {
                        images.get(i).setImageResource(R.drawable.doc_select_no);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 初始化小圆点
     */
    private void initDoc() {
        //首先需要一个集合记录这些小圆点的图片,,,,当页面切换的时候,可以从集合中取出imageView进行显示图片的设置
        images = new ArrayList<>();
        linearLayout.removeAllViews();//清空/移除所有的view

        for (int i = 0; i < list.size(); i++) {
            ImageView imageView = new ImageView(getActivity());

            if (i == 0) {//显示第一页,,,红的
                imageView.setImageResource(R.drawable.doc_select);
            } else {//绿的
                imageView.setImageResource(R.drawable.doc_select_no);
            }

            //添加到集合
            images.add(imageView);

            //加入到线性布局中显示
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(5, 0, 5, 0);

            linearLayout.addView(imageView, params);

        }
    }
    private void getData() {
        AsyncTask<Void, Void, String> asyncTask = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(path);

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    //设置
                    connection.setRequestMethod("GET");
                    connection.setReadTimeout(5000);
                    connection.setConnectTimeout(5000);

                    //获取
                    int responseCode = connection.getResponseCode();
                    if (responseCode == 200){
                        InputStream inputStream = connection.getInputStream();

                        //转换json
                        String json = streamToString(inputStream,"utf-8");

                        Log.i("---",json);
                        return json;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return "";
            }

            @Override
            protected void onPostExecute(String json) {
                //解析
                Gson gson = new Gson();
                NewsDataBean newsDataBean = gson.fromJson(json, NewsDataBean.class);

                //设置适配器
                NewsAdapter newsAdapter = new NewsAdapter(getActivity(), newsDataBean.getNewslist());

                listView.setAdapter(newsAdapter);
            }
        };

        asyncTask.execute();

    }

    private String streamToString(InputStream inputStream, String charset) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,charset);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String s = null;
            StringBuilder builder = new StringBuilder();
            while ((s = bufferedReader.readLine()) != null){
                builder.append(s);
            }

            bufferedReader.close();
            return builder.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return  null;
    }



}
