package com.test.androidstudy.homecloud.module.login;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.test.androidstudy.homecloud.bean.UserBean;
import com.test.androidstudy.homecloud.net.FormRequest;
import com.test.androidstudy.homecloud.net.HttpMethod;

/**
 * Created by zw on 16/10/21.
 */
public class RegisterHttpTask extends FormRequest {

    public RegisterHttpTask(@NonNull String mobile, @NonNull String pwd, boolean isOpen, String userName) {
        super();
        mBodyMap.put("mobile", mobile);
        mBodyMap.put("pwd", pwd);
        mBodyMap.put("isOpen", isOpen ? "1" : "0");
        if (!TextUtils.isEmpty(userName)) {
            mBodyMap.put("userName", userName);
        } else {
            mBodyMap.put("userName", "");

        }
    }

    @Override
    public String getApi() {
        return "user/register";
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
