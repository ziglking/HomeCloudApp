package com.test.androidstudy.homecloud.module.login;

import android.support.annotation.NonNull;

import com.test.androidstudy.homecloud.bean.UserBean;
import com.test.androidstudy.homecloud.net.*;
/**
 * Created by zw on 16/10/21.
 */
public class LoginHttpTask extends FormRequest {


    public LoginHttpTask(@NonNull String mobile, @NonNull String pwd) {
        super();
        mQueryMap.put("phone", mobile);
        mQueryMap.put("password", pwd);

    }

    @Override
    public String getApi() {
        return "user/login.do";
    }

    @Override
    public int getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    public Class getModelClass() {
        return UserBean.class;
    }
}
