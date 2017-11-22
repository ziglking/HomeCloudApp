package com.test.androidstudy.homecloud.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.androidstudy.homecloud.Constants;
import com.test.androidstudy.homecloud.R;
import com.test.androidstudy.homecloud.adapter.TabLayoutFragmentAdapter;
import com.test.androidstudy.homecloud.fragment.HomeFragment;
import com.test.androidstudy.homecloud.fragment.FeaturesFragment;
import com.test.androidstudy.homecloud.fragment.MeFragment;
import com.test.androidstudy.homecloud.fragment.SettingsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 2016/11/30.
 * Blog:http://blog.csdn.net/student9128
 * Description: Bottom Navigation Bar by TabLayout.
 */

public class MainActivity2 extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private List<String> mTabList = new ArrayList<>();
    private TabLayoutFragmentAdapter mAdapter;
    private int[] mTabImgs = new int[]{R.drawable.home, R.drawable.features, R.drawable.settings, R.drawable.me};
    private List<Fragment> mFragments = new ArrayList<>();

//    public static TabLayoutFragment newInstance(String s) {
//        TabLayoutFragment tabLayoutFragment = new TabLayoutFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString(Constants.ARGS, s);
//        tabLayoutFragment.setArguments(bundle);
//        return tabLayoutFragment;
//    }

    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        initTabList();
//        mAdapter = new TabLayoutFragmentAdapter(getChildFragmentManager(), mTabList, getActivity(), mFragments, mTabImgs);
        mAdapter = new TabLayoutFragmentAdapter(getSupportFragmentManager(), mTabList, getApplicationContext(), mFragments, mTabImgs);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(0);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            mTabLayout.getTabAt(i).setCustomView(mAdapter.getTabView(i));
        }
        mTabLayout.addOnTabSelectedListener(this);
//        mViewPager.setCurrentItem(0);
//        mTabLayout.getTabAt(0).setIcon(R.drawable.home);
//        mTabLayout.getTabAt(1).setIcon(R.drawable.location);
//        mTabLayout.getTabAt(2).setIcon(R.drawable.like);
//        mTabLayout.getTabAt(3).setIcon(R.drawable.person);
//        setDefaultFragment();
    }

    @Override
    public void onStart() {
        super.onStart();
        initFragmentList();
    }

    //睡前将中断的任务记录与此：
    //给每个Fragment添加newInstanc静态e函数，该函数返回一个Fragment实例，不需要参数
    //然后只需要添加xml布局文件即可
    private void setDefaultFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.sub_content, HomeFragment.newInstance(getString(R.string.item_home)))
                .commit();
    }

    /**
     * add Fragment
     */
    public void initFragmentList() {
        mFragments.clear();
        mFragments.add(HomeFragment.newInstance(getString(R.string.item_home)));
        mFragments.add(FeaturesFragment.newInstance(getString(R.string.item_features)));
        mFragments.add(SettingsFragment.newInstance(getString(R.string.item_settings)));
        mFragments.add(MeFragment.newInstance(getString(R.string.item_me)));

    }

    /**
     * init the tab list.
     */
    private void initTabList() {
        mTabList.clear();
        mTabList.add(getString(R.string.item_home));
        mTabList.add(getString(R.string.item_features));
        mTabList.add(getString(R.string.item_settings));
        mTabList.add(getString(R.string.item_me));
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        setTabSelectedState(tab);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        setTabUnSelectedState(tab);
    }


    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    private void setTabSelectedState(TabLayout.Tab tab) {
        View customView = tab.getCustomView();
        TextView tabText = (TextView) customView.findViewById(R.id.tv_tab_text);
        ImageView tabIcon = (ImageView) customView.findViewById(R.id.iv_tab_icon);
        tabText.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        String s = tabText.getText().toString();
        if (getString(R.string.item_home).equals(s)) {
            tabIcon.setImageResource(R.drawable.home_black);
        } else if (getString(R.string.item_features).equals(s)) {
            tabIcon.setImageResource(R.drawable.features_black);
        } else if (getString(R.string.item_settings).equals(s)) {
            tabIcon.setImageResource(R.drawable.settings_black);
        } else if (getString(R.string.item_me).equals(s)) {
            tabIcon.setImageResource(R.drawable.me_black);
        }
    }

    private void setTabUnSelectedState(TabLayout.Tab tab) {
        View customView = tab.getCustomView();
        TextView tabText = (TextView) customView.findViewById(R.id.tv_tab_text);
        ImageView tabIcon = (ImageView) customView.findViewById(R.id.iv_tab_icon);
        tabText.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black_1));
        String s = tabText.getText().toString();
        if (getString(R.string.item_home).equals(s)) {
            tabIcon.setImageResource(R.drawable.home);
        } else if (getString(R.string.item_features).equals(s)) {
            tabIcon.setImageResource(R.drawable.features);
        } else if (getString(R.string.item_settings).equals(s)) {
            tabIcon.setImageResource(R.drawable.settings);
        } else if (getString(R.string.item_me).equals(s)) {
            tabIcon.setImageResource(R.drawable.me);
        }
    }
}
