package com.test.androidstudy.homecloud.module.login;

import com.test.androidstudy.homecloud.bean.UserBean;
import com.test.androidstudy.homecloud.net.*;
/**
 * Created by zw on 16/10/26.
 * 修改密码
 */
public class ResetPwdHttpTask extends FormRequest {
    public ResetPwdHttpTask(String mobile, String pwd) {
        super();
        this.mBodyMap.put("mobile", mobile);
        this.mBodyMap.put("newPwd", pwd);
    }

    @Override
    public String getApi() {
        return "user/forgetPwd";
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
