package com.test.androidstudy.homecloud.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.androidstudy.homecloud.R;

/**
 * Created by wangxiang on 2017/11/20.
 */

public class MeFragment extends Fragment  implements View.OnClickListener{
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

//        view.findViewById(R.id.switch_alertor).setOnClickListener(this);
//        view.findViewById(R.id.switch_light).setOnClickListener(this);
//        view.findViewById(R.id.switch_thermometer).setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        //TODO 个人信息相关功能按钮
    }
}
