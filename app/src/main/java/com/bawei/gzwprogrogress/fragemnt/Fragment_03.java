package com.bawei.gzwprogrogress.fragemnt;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.bawei.gzwprogrogress.R;
import com.bawei.gzwprogrogress.adapter.HoAdapter;
import com.bawei.gzwprogrogress.fragment.Fragment_left;
import com.bawei.gzwprogrogress.fragment.Fragment_right;

import java.util.ArrayList;

/**
 * Created by Adminjs on 2017/12/15.
 */

public class Fragment_03 extends Fragment{

    private ArrayList<Fragment> listn;
    private HoAdapter adapter;
    private ViewPager pager;
    private RadioGroup group;
    private SharedPreferences config;
    private SharedPreferences.Editor edit;
    private ViewPager viewpager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        SharedPreferences sp = getActivity().getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
//        int uid = sp.getInt("uid", 0);
//        System.out.println("SharedPreferences"+sp.getInt("uid",0));
//        if(uid==3859){
//            System.out.println("SharedPreferences///if"+sp.getInt("uid",0));
//
//            Toast.makeText(getActivity(),"登录", Toast.LENGTH_SHORT).show();

           View view = inflater.inflate(R.layout.fragemnt_03,container,false);
//            Log.i("请求数据",uid+"");
            listn = new ArrayList<>();
            listn.add(new Fragment_left());
            listn.add(new Fragment_right());
            group = view.findViewById(R.id.radiogroup);
            pager = view.findViewById(R.id.pagern);
            adapter = new HoAdapter(getFragmentManager(),listn);
            pager.setAdapter(adapter);

            pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    group.check(group.getChildAt(position).getId());
                }

                @Override
                public void onPageSelected(int position) {

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
            pager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
            group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    switch (i){
                        case R.id.radio_1:
                            pager.setCurrentItem(0,false);
                            break;
                        case R.id.radio_2:
                            pager.setCurrentItem(1,false);
                            break;
                    }
                }
            });
            pager.setOffscreenPageLimit(2);
            return view;
  //      }
//       else{
//            System.out.println("SharedPreferenceselse"+sp.getInt("uid",0));
//            Toast.makeText(getActivity(),"未登录", Toast.LENGTH_SHORT).show();
//            View view1 = inflater.inflate(R.layout.fragment03,container,false);
//            Button tiao = view1.findViewById(R.id.tiao);
//            tiao.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(getActivity(), LoginActivity.class);
//                    startActivity(intent);
//                }
//            });
//        return view1;
        }
    }
//}
