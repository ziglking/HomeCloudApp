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

public class FeaturesFragment extends Fragment implements View.OnClickListener{
    public static FeaturesFragment newInstance(@Nullable String s){
        FeaturesFragment featuresFragment = new FeaturesFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString(Constants.ARGS,s);
//        homeFragment.setArguments(bundle);
        return featuresFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_features, null);
//        Bundle bundle = getArguments();
//        String s = bundle.getString(Constants.ARGS);
//        TextView textView = (TextView) view.findViewById(R.id.fragment_text_view);
//        textView.setText(s);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.switch_alertor).setOnClickListener(this);
        view.findViewById(R.id.switch_light).setOnClickListener(this);
        view.findViewById(R.id.switch_thermometer).setOnClickListener(this);

        view.findViewById(R.id.switch_alertor1).setOnClickListener(this);
        view.findViewById(R.id.switch_light1).setOnClickListener(this);
        view.findViewById(R.id.switch_thermometer1).setOnClickListener(this);

        view.findViewById(R.id.switch_alertor2).setOnClickListener(this);
        view.findViewById(R.id.switch_light2).setOnClickListener(this);
        view.findViewById(R.id.switch_thermometer2).setOnClickListener(this);

        view.findViewById(R.id.btn_refresh_devices).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //TODO 与硬件通信
        switch(view.getId()){
            case R.id.switch_alertor:
                break;
            case R.id.switch_light:
                break;
            case R.id.switch_thermometer:
                break;
            case R.id.switch_alertor1:
                break;
            case R.id.switch_light1:
                break;
            case R.id.switch_thermometer1:
                break;
            case R.id.switch_alertor2:
                break;
            case R.id.switch_light2:
                break;
            case R.id.switch_thermometer2:
                break;
            case R.id.btn_refresh_devices:
                break;
        }
    }
}
