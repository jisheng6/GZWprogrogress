package com.bawei.gzwprogrogress.activity;

import com.bawei.gzwprogrogress.bean.LoginBean;
import com.bawei.gzwprogrogress.bean.RegistBean;
import com.bawei.gzwprogrogress.bean.XiangqingBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by dream on 2017/12/12.
 */

public interface Service {
    ///http://120.27.23.105/user/login
    @GET("user/login")
    Observable<LoginBean> getLogin(@Query("mobile") String mobile, @Query("password") String passwprd);
   @GET("user/reg")
    Observable<RegistBean> getRegist(@Query("mobile") String mobile, @Query("password") String passwprd);
   //http://120.27.23.105/
   @GET("user/getUserInfo")
    Observable<XiangqingBean> getUid(@Query("uid") String uid);


}
