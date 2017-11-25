package com.test.androidstudy.homecloud.module.login;

import android.support.annotation.NonNull;

import com.test.androidstudy.homecloud.bean.UserBean;
import com.test.androidstudy.homecloud.net.*;
/**
 * Created by zw on 16/10/21.
 */
public class RegisterHttpTask extends FormRequest {

    public RegisterHttpTask(@NonNull String mobile, @NonNull String pwd, boolean isOpen, String userName) {
        super();
        mBodyMap.put("phone", mobile);
        mBodyMap.put("password", pwd);
//        mBodyMap.put("isOpen", isOpen ? "1" : "0");
//        if (!TextUtils.isEmpty(userName)) {
//            mBodyMap.put("userName", userName);
//        } else {
//            mBodyMap.put("userName", "");
//
//        }
    }

    @Override
    public String getApi() {
        return "user/addUser.do";
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
