package com.test.androidstudy.homecloud.activity;


import android.support.v7.app.AppCompatActivity;

import com.test.androidstudy.homecloud.bean.UserBean;
import com.test.androidstudy.homecloud.module.login.LoginAction;
import com.test.androidstudy.homecloud.utils.ToastWrapper;

/**
 * Created by zw on 16/11/22.
 */
public abstract class LoginBaseActivity extends AppCompatActivity implements LoginAction.ILoginCB {

    public void onLoginSuccess(UserBean userBean) {
//        Activity entryActivity = getActivity();
//        if (entryActivity != null) {
//            entryActivity.setResult(LoginAction.LOGIN_CODE);
//            entryActivity.finish();
//        }
        //之前是fragment ，改成activity
        this.setResult(LoginAction.LOGIN_CODE);
        this.finish();
    }

    public void onLoginFailed(int code, String message) {
        ToastWrapper.makeShortToast(message);
    }
}
