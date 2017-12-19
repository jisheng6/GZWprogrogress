package com.bawei.gzwprogrogress.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

import com.bawei.gzwprogrogress.R;

/**
 * Created by Adminjs on 2017/12/16.
 */

public class CaActivity extends Activity{
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    Intent intent = new Intent(CaActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case 1:
                    Intent intent1 = new Intent(CaActivity.this,MainActivity.class);
                    startActivity(intent1);
                    finish();
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ca);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //进入页面存值
        SharedPreferences preferences = getSharedPreferences("config", 0);
        boolean flag = preferences.getBoolean("flag", false);
        if(flag){
            //第二次进入是true
            handler.sendEmptyMessage(1);
        }else{
            //一开始是false.存值为true
            preferences.edit().putBoolean("flag",true).commit();
            handler.sendEmptyMessageDelayed(0,3000);
        }

    }
}

