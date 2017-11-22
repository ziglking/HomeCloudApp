package com.test.androidstudy.homecloud.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.test.androidstudy.homecloud.R;
import com.test.androidstudy.homecloud.module.login.LoginAction;
import com.test.androidstudy.homecloud.utils.PhoneNumberHelper;
import com.test.androidstudy.homecloud.utils.ToastWrapper;
import com.sina.weibo.sdk.utils.MD5;

/**
 * Created by zw on 16/10/21.
 */

public class RegisterFragment extends LoginBaseFragment implements View.OnClickListener {
    private EditText mEdtMobile;
    private EditText mEdtPwd;
//    private EditText mEdtUsername;
    private EditText mEdtPwdConfirm;
    private View mRootView;

    public static void start(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, RegisterFragment.class);
        context.startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_register, container, false);
        return mRootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mEdtMobile = (EditText) mRootView.findViewById(R.id.edtRegisterPhoneNum);
        mEdtPwd = (EditText) mRootView.findViewById(R.id.edtRegisterPwd);
        //mEdtUsername = (EditText) mRootView.findViewById(R.id.edtRegisterUsername);
        mEdtPwdConfirm = (EditText) mRootView.findViewById(R.id.edtPwdConfirm);
        mRootView.findViewById(R.id.btn_register).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_register) {
            String mobile = mEdtMobile.getText().toString();
            String pwd = mEdtPwd.getText().toString();
            String pwdConfirm = mEdtPwdConfirm.getText().toString();
//            String usrName = mEdtUsername.getText().toString();

            if (!PhoneNumberHelper.isMobile(mobile)) {
                ToastWrapper.makeShortToast(R.string.login_mobile_hint);
                mEdtMobile.requestFocus();
                return;
            }

//            if (TextUtils.isEmpty(usrName)) {
//                ToastWrapper.makeShortToast(R.string.login_username_empty);
//
//                mEdtUsername.requestFocus();
//                return;
//            }


            if (TextUtils.isEmpty(pwd) || pwd.length() < 6) {
                ToastWrapper.makeShortToast(R.string.login_pwd_too_short);
                mEdtPwd.requestFocus();
                return;
            }


            if (pwd.length() > 20) {
                ToastWrapper.makeShortToast(R.string.login_pwd_too_long);
                mEdtPwd.requestFocus();
                return;
            }

            if(!pwd.equals(pwdConfirm)){
                ToastWrapper.makeShortToast(R.string.register_inconsistent_pwd);
                mEdtPwdConfirm.requestFocus();
                return;
            }
//            LoginAction.register(mobile, usrName, MD5.hexdigest(pwd), this);
            LoginAction.register(mobile, null, MD5.hexdigest(pwd), this);
        }
    }


}
