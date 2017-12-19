package com.bawei.gzwprogrogress.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.bawei.gzwprogrogress.R;
import com.bawei.gzwprogrogress.activity.LoginActivity;

/**
 * Created by Adminjs on 2017/12/15.
 */

public class Fragemnt3 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SharedPreferences sp = getActivity().getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
        int uid = sp.getInt("uid", 0);
        if(uid==0) {
            Toast.makeText(getActivity(), "未登录", Toast.LENGTH_SHORT).show();
            View view1 = inflater.inflate(R.layout.fragment3, container, false);
            Button tiao = view1.findViewById(R.id.tiaoo);
            tiao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
            });
            return view1;
        }else {
            Toast.makeText(getActivity(), "登录", Toast.LENGTH_SHORT).show();
            View view = inflater.inflate(R.layout.fragemnt_3, container, false);
            return view;
        }
    }
}
