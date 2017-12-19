package com.bawei.gzwprogrogress.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Adminjs on 2017/12/15.
 */

public class HoAdapter extends FragmentPagerAdapter{
    List<Fragment>listn;

    public HoAdapter(FragmentManager fm, List<Fragment> listn) {
        super(fm);
        this.listn = listn;
    }

    @Override
    public Fragment getItem(int position) {
        return listn.get(position);
    }

    @Override
    public int getCount() {
        return listn.size();
    }
}
