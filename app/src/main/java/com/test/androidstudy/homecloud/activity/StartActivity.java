package com.test.androidstudy.homecloud.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.test.androidstudy.homecloud.ExerciseConst;
import com.test.androidstudy.homecloud.R;
import com.test.androidstudy.homecloud.adapter.ViewPagerAdapter;
//demo中这个activity作为第一次启动APP时显示，有宣传作用，是连续的几张图像，使用了viewpager
import com.test.androidstudy.homecloud.bean.UserBean;
import com.test.androidstudy.homecloud.module.login.LoginAction;
import com.test.androidstudy.homecloud.module.login.UserProfile;

import java.util.ArrayList;

public class StartActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_start);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //autoLogin();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                chargeSharePreference();
            }
        }, 2000);
    }

    //判定并自动登录
//    private void autoLogin(){
//        UserBean userBean  =   UserProfile.loadLocalUser();
//        if(userBean!=null&& !TextUtils.isEmpty(userBean.getToken())){
//            //只发请求，不关心结果
//            LoginAction.tokenLogin(userBean.getToken());
//        }
//    }

    private void chargeSharePreference() {
        SharedPreferences sp = getSharedPreferences(ExerciseConst.MAIN_PREFERENCE_FILE, Activity.MODE_PRIVATE);
        boolean isFirstStart = sp.getBoolean(ExerciseConst.PREFERENCE_KEY.FIRST_START_APP, true);
        if (isFirstStart) {
            initViewAndData();
        } else {
            Intent intent = new Intent(StartActivity.this, MainActivity2.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
    }

    private void initViewAndData() {
        //还没有相应的资源文件,随意安放了几张图片
        ViewPager startViewPager = (ViewPager) findViewById(R.id.start_viewpager);
        ArrayList<View> views = new ArrayList<>();
        LayoutInflater inflater = getLayoutInflater();
        ImageView vpStart01 = new ImageView(this);
        vpStart01.setScaleType(ImageView.ScaleType.CENTER_CROP);
        vpStart01.setImageResource(R.drawable.welcome1);
        ImageView vpStart02 = new ImageView(this);
        vpStart02.setScaleType(ImageView.ScaleType.CENTER_CROP);
        vpStart02.setImageResource(R.drawable.welcome2);
        views.add(vpStart01);
        views.add(vpStart02);
        View vpStart03 = inflater.inflate(R.layout.viewpager_start, null);
        views.add(vpStart03);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(views);
        startViewPager.setAdapter(viewPagerAdapter);
        startViewPager.setCurrentItem(0);
        Button startNowGoBtn = (Button) vpStart03.findViewById(R.id.start_now_go_bt);
        startNowGoBtn.setOnClickListener(this);
        startViewPager.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_now_go_bt:
                saveStartSharedPreferenceFlag();
                Intent intent = new Intent(StartActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void saveStartSharedPreferenceFlag() {
        SharedPreferences sp = getSharedPreferences(ExerciseConst.MAIN_PREFERENCE_FILE, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(ExerciseConst.PREFERENCE_KEY.FIRST_START_APP, false);
        editor.apply();
    }
}
