package com.test.androidstudy.homecloud.module.login;

import android.support.annotation.NonNull;

import com.test.androidstudy.homecloud.bean.UserBean;
import com.test.androidstudy.homecloud.net.FormRequest;
import com.test.androidstudy.homecloud.net.HttpMethod;

/**
 * Created by zw on 16/10/21.
 */
public class LoginHttpTask extends FormRequest {


    public LoginHttpTask(@NonNull String mobile, @NonNull String pwd) {
        super();
        mBodyMap.put("mobile", mobile);
        mBodyMap.put("pwd", pwd);

    }

    @Override
    public String getApi() {
        return "user/login";
    }

    @Override
    public int getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    public Class getModelClass() {
        return UserBean.class;
    }
}
