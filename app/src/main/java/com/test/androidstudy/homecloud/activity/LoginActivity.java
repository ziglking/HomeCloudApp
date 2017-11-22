package com.test.androidstudy.homecloud.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.test.androidstudy.homecloud.R;
import com.test.androidstudy.homecloud.module.login.LoginAction;
import com.test.androidstudy.homecloud.utils.PhoneNumberHelper;
import com.test.androidstudy.homecloud.utils.ToastWrapper;
import com.sina.weibo.sdk.utils.MD5;

/**
 * Created by zw on 16/10/29.
 */
public class LoginActivity extends LoginBaseActivity implements View.OnClickListener {
    private EditText mEdtMobile;
    private EditText mEdtPwd;

    public static void launch(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEdtMobile = (EditText) findViewById(R.id.edtLoginMobile);
        mEdtPwd = (EditText) findViewById(R.id.edtLoginPwd);
        findViewById(R.id.btn_login).setOnClickListener(this);
        findViewById(R.id.txt_reg).setOnClickListener(this);
    }



    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_login: {

                String mobile = mEdtMobile.getText().toString();
                String pwd = mEdtPwd.getText().toString();


                if (!PhoneNumberHelper.isMobile(mobile)) {
                    ToastWrapper.makeShortToast(R.string.login_mobile_hint);
                    mEdtMobile.requestFocus();
                    return;
                }

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

                LoginAction.login(mobile, MD5.hexdigest(pwd), this);
            }

            break;
//            case R.id.txtForgetPwd: {
//                ((EntranceActivity) getActivity()).switchRePwdFragment();
//            }
//            break;
            case R.id.txt_reg: {//点击注册需要跳转到注册activity，但是只有注册fragment
                RegisterActivity.launch(this);
            }
            break;
        }
    }


}
