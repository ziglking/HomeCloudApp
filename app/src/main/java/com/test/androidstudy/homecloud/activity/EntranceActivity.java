package com.test.androidstudy.homecloud.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.test.androidstudy.homecloud.R;

/**
 * Created by zw on 16/10/21.
 */
//不再使用这个entranceactivity作为登录，注册，改密码的载体，
// 因为登录注册改密码都采用了activity而不再使用fragment来实现
public class EntranceActivity extends Activity {
//    private LoginActivity mLoginFragment;
//    private RegisterActivity mRegisterFragment;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_entrance);
//        mLoginFragment = new LoginActivity();
//        mRegisterFragment = new RegisterActivity();
//        switchLoginFragment();
//    }
//
//
//    private void switchLoginFragment() {
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.add(R.id.fragment_container, mLoginFragment);
//        transaction.commit();
//    }
//
//    public void switchRegisterFragment() {
//        switchFragment(mRegisterFragment);
//    }
//
//
//    public void switchRePwdFragment() {
//        switchFragment(mRePwdFragment);
//    }
//
//    private void switchFragment(Fragment fragment) {
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.add(R.id.fragment_container, fragment);
//        transaction.addToBackStack("");
//        transaction.commit();
//    }
//
//    protected void onNavigationBackButtonPressed() {
//        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
//        if(backStackEntryCount==0)
//            finish();
//        else{
//            getSupportFragmentManager().popBackStack();
//        }
//    }
//
//    public static void launch(Context context) {
//        launch(context, 0);
//    }
//
//    public static void launch(Context context, int code) {
//        Intent intent = new Intent();
//        intent.setClass(context, EntranceActivity.class);
//        if (code == 0) {
//            context.startActivity(intent);
//        } else {
//            ((Activity) context).startActivityForResult(intent, code);
//        }
//    }
}
