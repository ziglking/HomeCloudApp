package com.test.androidstudy.homecloud.module.login;

import com.test.androidstudy.homecloud.bean.TokenBean;
import com.test.androidstudy.homecloud.net.*;
/**
 * Created by zw on 16/10/21.
 */
public class TokenLoginHttpTask extends FormRequest {


    public TokenLoginHttpTask() {
        super();

    }

    @Override
    public String getApi() {
        return "user/loginByToken";
    }

    @Override
    public int getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    public Class getModelClass() {
        return TokenBean.class;
    }
}
