package com.test.androidstudy.homecloud.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.androidstudy.homecloud.R;

/**
 * Created by wangxiang on 2017/11/19.
 */

public class SettingsFragment extends Fragment implements View.OnClickListener{
    public static SettingsFragment newInstance(@Nullable String s){
        SettingsFragment settingsFragment = new SettingsFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString(Constants.ARGS,s);
//        homeFragment.setArguments(bundle);
        return settingsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, null);
//        Bundle bundle = getArguments();
//        String s = bundle.getString(Constants.ARGS);
//        TextView textView = (TextView) view.findViewById(R.id.fragment_text_view);
//        textView.setText(s);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.setting1).setOnClickListener(this);
        view.findViewById(R.id.setting2).setOnClickListener(this);
        view.findViewById(R.id.setting3).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //TODO  具体有设置项待定
    }

}
