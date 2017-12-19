package com.bawei.gzwprogrogress.fragemnt;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.bawei.gzwprogrogress.R;
import com.bawei.gzwprogrogress.adapter.HomeAdapter;
import com.bawei.gzwprogrogress.fragemn.Fragemnt001;
import com.bawei.gzwprogrogress.fragemn.Fragemnt002;
import com.bawei.gzwprogrogress.fragemn.Fragemnt003;
import com.bawei.gzwprogrogress.fragemn.Fragemnt004;
import com.bawei.gzwprogrogress.fragemn.Fragemnt005;
import com.bawei.gzwprogrogress.fragemn.Fragemnt006;
import com.bawei.gzwprogrogress.fragemn.Fragemnt007;
import com.bawei.gzwprogrogress.fragemn.Fragemnt008;
import com.zaaach.citypicker.CityPickerActivity;

import java.util.ArrayList;

/**
 * Created by Adminjs on 2017/12/15.
 */

public class Fragment_01 extends Fragment{

    private static final int REQUEST_CODE_PICK_CITY = 0;
    private ViewPager viewpager;
    private ArrayList<String> list;
    private TabLayout tabLayout;
    private HomeAdapter adapter;
    private TextView guo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragemnt_01,container,false);
        tabLayout = view.findViewById(R.id.tab_layout);
        ArrayList<Fragment> fragment = new ArrayList<>();
        fragment.add(new Fragemnt001());
        fragment.add(new Fragemnt002());
        fragment.add(new Fragemnt003());
        fragment.add(new Fragemnt004());
        fragment.add(new Fragemnt005());
        fragment.add(new Fragemnt006());
        fragment.add(new Fragemnt007());
        fragment.add(new Fragemnt008());
        guo = view.findViewById(R.id.guo);
        adapter = new HomeAdapter(getFragmentManager(), fragment);
        adapter.setData(fragment);
        viewpager = view.findViewById(R.id.view_pager);
        list = new ArrayList<>();
        list.add("全部");
        list.add("综艺娱乐");
        list.add("财经访谈");
        list.add("文化旅游");
        list.add("时尚体育");
        list.add("青少科技");
        list.add("养生保健");
        list.add("公益");
        adapter.setTabs(list);
        viewpager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewpager);
        return view;
        }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        guo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //启动
                startActivityForResult(new Intent(getActivity(), CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);

            }
        });
    }
    //重写onActivityResult方法
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == getActivity().RESULT_OK){
            if (data != null){
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                guo.setText(city);
            }
        }
    }

}
