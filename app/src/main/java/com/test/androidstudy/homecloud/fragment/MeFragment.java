package com.test.androidstudy.homecloud.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.test.androidstudy.homecloud.R;
import com.test.androidstudy.homecloud.activity.LoginActivity;
import com.test.androidstudy.homecloud.activity.RegisterActivity;
import com.test.androidstudy.homecloud.module.login.UserProfile;

/**
 * Created by wangxiang on 2017/11/20.
 */

public class MeFragment extends Fragment  implements View.OnClickListener{
    private TextView mTextView;
    private Button mButton;
    public static MeFragment newInstance(@Nullable String s){
        MeFragment meFragment = new MeFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString(Constants.ARGS,s);
//        homeFragment.setArguments(bundle);
        return meFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, null);
//        Bundle bundle = getArguments();
//        String s = bundle.getString(Constants.ARGS);
//        TextView textView = (TextView) view.findViewById(R.id.fragment_text_view);
//        textView.setText(s);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mButton = (Button) view.findViewById(R.id.btn_login);
        mButton.setOnClickListener(this);
//        mTextView = view.findViewById(R.id.tv_personal_info);
//        view.findViewById(R.id.switch_thermometer).setOnClickListener(this);
        //TODO 在这里检查是否已经登录，根据结果设定按钮是登录还是注销
        if(UserProfile.isLogin()){
            mButton.setText("注销");
        }
    }
    @Override
    public void onClick(View view) {
        //TODO 个人信息相关功能按钮
        switch (view.getId()){
            case R.id.btn_login:
                if(mButton.getText().equals("登录")){
                    LoginActivity.launch(getContext());
                }else {
                    RegisterActivity.launch(getContext());
                }
        }
    }
}
