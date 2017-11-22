package com.test.androidstudy.homecloud.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.test.androidstudy.homecloud.bean.RecentIndoorInfoBean;
import com.test.androidstudy.homecloud.adapter.RecentIndoorInfoAdapter;
import com.test.androidstudy.homecloud.R;
import com.test.androidstudy.homecloud.activity.ChartsActivity;
import com.test.androidstudy.homecloud.activity.DetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangxiang on 2017/11/19.
 */

public class HomeFragment extends Fragment implements View.OnClickListener {
    public static HomeFragment newInstance(@Nullable String s){
        HomeFragment homeFragment = new HomeFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString(Constants.ARGS,s);
//        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
//        Bundle bundle = getArguments();
//        String s = bundle.getString(Constants.ARGS);
//        TextView textView = (TextView) view.findViewById(R.id.fragment_text_view);
//        textView.setText(s);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.current_info).setOnClickListener(this);
        view.findViewById(R.id.chart_btn).setOnClickListener(this);

        ListView listView =  view.findViewById(R.id.list_view);

        final List<RecentIndoorInfoBean> data = new ArrayList<>();
        final BaseAdapter adapter = new RecentIndoorInfoAdapter(this.getContext(), data);
        listView.setAdapter(adapter);
//TODO  在这里开启一个异步任务向服务器申请数据保存到list中,数据回传成功之后更新ListView
//        View addMessage = view.findViewById(add_message);
//        addMessage.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                data.add(new RecentIndoorInfoBean("我是文本消息" + data.size()));
//                adapter.notifyDataSetChanged();
//            }
//        });
    }

    @Override
    public void onClick(View view) {
//        if (!UserProfile.isLogin()) {
//            EntranceActivity.launch(getActivity());
//            return;
//        }
        switch (view.getId()) {
            case R.id.current_info: {
                navToChartActivity();
                break;
            }
            case R.id.chart_btn: {
                navToDetailsActivity();
                break;
            }
        }
    }

    private void navToChartActivity(){
        ChartsActivity.launch(getContext());
    }

    private void navToDetailsActivity(){
        DetailActivity.launch(getContext());}

}
