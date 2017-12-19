package com.bawei.gzwprogrogress.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.tech.NfcA;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.gzwprogrogress.R;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Adminjs on 2017/12/16.
 */

public class TuiActivity extends Activity{

    private TextView phone;
    private TextView fun;
    private TextView tui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tui);
        phone = findViewById(R.id.phone);
        fun = findViewById(R.id.fan);
        tui = findViewById(R.id.button);
        Bundle buddle = getIntent().getExtras();
        String name1 = buddle.getString("name");
        phone.setText(name1);

        fun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              finish();
            }
        });
       tui.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               SharedPreferences sp= getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
               sp.edit().clear().commit();
               Toast.makeText(TuiActivity.this, "已清空", Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(TuiActivity.this, MainActivity.class);
               startActivity(intent);
           }
       });
    }
    }
