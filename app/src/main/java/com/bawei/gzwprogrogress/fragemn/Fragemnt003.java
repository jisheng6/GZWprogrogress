package com.bawei.gzwprogrogress.fragemn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.bawei.gzwprogrogress.R;
import com.bawei.gzwprogrogress.adapter.MyGridAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adminjs on 2017/12/15.
 */

public class Fragemnt003 extends Fragment{
    private GridView list;
    private List<String> listT = new ArrayList<>();
    private List<Integer> imgT = new ArrayList<>();
    private GridView gridView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragemnt_003,container,false);
        gridView = view.findViewById(R.id.gridview);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listT.add("花");
        listT.add("草");
        listT.add("树");
        listT.add("木");
        listT.add("天空");
        listT.add("大海");
        imgT.add(R.drawable.a);
        imgT.add(R.drawable.b);
        imgT.add(R.drawable.c);
        imgT.add(R.drawable.d);
        imgT.add(R.drawable.e);
        imgT.add(R.drawable.f);
        MyGridAdapter myGridAdapter = new MyGridAdapter(listT,imgT,getActivity());
        gridView.setAdapter(myGridAdapter);
    }
}
