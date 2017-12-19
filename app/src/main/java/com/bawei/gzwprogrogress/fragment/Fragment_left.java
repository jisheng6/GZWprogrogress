package com.bawei.gzwprogrogress.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.bawei.gzwprogrogress.R;
import com.bawei.gzwprogrogress.adapter.HomAdapter;
import com.bawei.gzwprogrogress.fragment.Fragemnt1;
import com.bawei.gzwprogrogress.fragment.Fragemnt2;
import com.bawei.gzwprogrogress.fragment.Fragemnt3;
import com.bawei.gzwprogrogress.fragment.Fragemnt4;

import java.util.ArrayList;

/**
 * Created by Adminjs on 2017/12/15.
 */

public class Fragment_left extends Fragment{
    private ArrayList<Fragment> lis;
    private ViewPager pager;
    private RadioGroup group;
    private ArrayList<String> list1;
    private HomAdapter adapter;
    private TabLayout tab;
    private SharedPreferences config;
    private SharedPreferences.Editor edit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragemnt_left,container,false);
        lis = new ArrayList<>();
        lis.add(new Fragemnt1());
        lis.add(new Fragemnt2());
        lis.add(new Fragemnt3());
        lis.add(new Fragemnt4());
        list1 = new ArrayList<>();
        list1.add("待审核");
        list1.add("待支付");
        list1.add("待参加");
        list1.add("已完成");
        pager = view.findViewById(R.id.manaxi_viewpager);
        tab = view.findViewById(R.id.tab_layo);
        adapter = new HomAdapter(getFragmentManager(), lis);
        adapter.setData(lis);
        adapter.setTabs(list1);
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);
        return view;
    }
}
