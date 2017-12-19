package com.bawei.gzwprogrogress.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawei.gzwprogrogress.R;
import com.bawei.gzwprogrogress.adapter.MyAdapter;
import com.bawei.gzwprogrogress.fragemnt.Fragment_01;
import com.bawei.gzwprogrogress.fragemnt.Fragment_02;
import com.bawei.gzwprogrogress.fragemnt.Fragment_03;
import com.bawei.gzwprogrogress.fragemnt.Fragment_04;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    private ViewPager pager;
    private ArrayList<Fragment> list;
    private RadioGroup group;
    private RadioButton radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.pager);
        group = findViewById(R.id.group);
        list = new ArrayList<>();
        list.add(new Fragment_01());
        list.add(new Fragment_02());
        list.add(new Fragment_03());
        list.add(new Fragment_04());

        radio = findViewById(R.id.radio_02);
        radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(), list);
        pager.setAdapter(myAdapter);
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
                    case R.id.radio_01:
                       pager.setCurrentItem(0,false);
                        break;
                    case R.id.radio_02:
  //                      pager.setCurrentItem(1,true);
                        break;
                    case R.id.radio_03:
                        pager.setCurrentItem(2,false);
                        break;
                    case R.id.radio_04:
                        pager.setCurrentItem(3,false);
                        break;
                }
            }
        });
        pager.setOffscreenPageLimit(3);

    }
}
