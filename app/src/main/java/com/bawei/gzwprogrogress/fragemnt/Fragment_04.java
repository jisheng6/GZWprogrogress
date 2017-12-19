package com.bawei.gzwprogrogress.fragemnt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.gzwprogrogress.R;
import com.bawei.gzwprogrogress.activity.LoginActivity;
import com.bawei.gzwprogrogress.activity.Service;
import com.bawei.gzwprogrogress.activity.TuiActivity;
import com.bawei.gzwprogrogress.bean.XiangqingBean;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Adminjs on 2017/12/15.
 */

public class Fragment_04 extends Fragment{

    private ImageView imag;
    TextView username;
    private TextView tui;
    private ImageView ima;
    private SharedPreferences mySharedPreferences;
    private SharedPreferences sp;
    private String name;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragemnt_04,container,false);
        imag = view.findViewById(R.id.imag);
        username = view.findViewById(R.id.username);
        ima = view.findViewById(R.id.ima);
        imag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        SharedPreferences sp = getActivity().getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
//        int uid = sp.getInt("uid", 0);
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://120.27.23.105")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//        Service service = retrofit.create(Service.class);
//
//            service.getUid(3859 + "").subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(new Observer<XiangqingBean>() {
//                        @Override
//                        public void onCompleted() {
//
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//
//                        }
//
//                        @Override
//                        public void onNext(XiangqingBean xiangqingBean) {
//                            name = xiangqingBean.getData().getUsername();
//                            username.setText(name);
//                        }
//                    });
//

        SharedPreferences sp=getActivity().getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
        name=sp.getString("name", null);
        System.out.println("传值"+sp.getString("name", null));
        if (name == null)
        {
            username.setText("未登录");
        }else{
            username.setText(name);

        }
        ima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),TuiActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
