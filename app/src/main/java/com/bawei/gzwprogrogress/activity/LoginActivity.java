package com.bawei.gzwprogrogress.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.gzwprogrogress.R;
import com.bawei.gzwprogrogress.bean.LoginBean;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Adminjs on 2017/12/16.
 */

public class LoginActivity extends Activity {
    private EditText phone;
    private EditText pass;
    private Button lu;
    private Button ce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phone = findViewById(R.id.phone);
        pass = findViewById(R.id.pass);
        lu = findViewById(R.id.login_lu);
        ce = findViewById(R.id.login_ce);

        lu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p = phone.getText().toString().trim();
                String pa = pass.getText().toString().trim();
                Retrofit retrofit =  new Retrofit.Builder()
                        .baseUrl("http://120.27.23.105")
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();
                Service service = retrofit.create(Service.class);
                service.getLogin(p,pa).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<LoginBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(LoginBean loginBean) {
                                String code = loginBean.getCode();
                               int uid = loginBean.getData().getUid();
                               String mobile = loginBean.getData().getMobile();
                                SharedPreferences sp = getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
                                SharedPreferences.Editor edit=sp.edit();
                                edit.putString("name",mobile);
                                edit.putInt("uid",uid);
                                edit.commit();
                                System.out.println("传值1"+ edit.putString("name",mobile));
                                System.out.println("传值2"+ edit.putString("uid",uid+""));

                                if (code.equals("0")){
                                    Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


            }
        });
        ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ZhuceActivity.class);
                startActivity(intent);
            }
        });
    }
}

