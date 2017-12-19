package com.bawei.gzwprogrogress.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.gzwprogrogress.R;

/**
 * Created by Adminjs on 2017/12/15.
 */

public class HomeActivity extends Activity{

    private Button gaun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        gaun = findViewById(R.id.guan);
        gaun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        LinearLayout fa = findViewById(R.id.fa);
        LinearLayout qi = findViewById(R.id.qi);
        fa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "发布活动", Toast.LENGTH_SHORT).show();
            }
        });
        qi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "敬请期待。。。", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
