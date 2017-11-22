package com.test.androidstudy.homecloud.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.test.androidstudy.homecloud.bean.UserBean;
import com.test.androidstudy.homecloud.module.login.LoginAction;
import com.test.androidstudy.homecloud.utils.ToastWrapper;

/**
 * Created by zw on 16/11/22.
 */
public abstract class LoginBaseFragment extends Fragment implements LoginAction.ILoginCB {

    public void onLoginSuccess(UserBean userBean) {
        Activity entryActivity = getActivity();
        if (entryActivity != null) {
            entryActivity.setResult(LoginAction.LOGIN_CODE);
            entryActivity.finish();
        }
    }

    public void onLoginFailed(int code, String message) {
        ToastWrapper.makeShortToast(message);
    }
}
