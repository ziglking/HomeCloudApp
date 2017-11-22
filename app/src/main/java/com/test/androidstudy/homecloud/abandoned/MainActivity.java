package com.test.androidstudy.homecloud.abandoned;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.test.androidstudy.homecloud.fragment.FeaturesFragment;
import com.test.androidstudy.homecloud.fragment.HomeFragment;
import com.test.androidstudy.homecloud.R;
import com.test.androidstudy.homecloud.fragment.SettingsFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private PagerSlidingTabStrip mPagerTab;
    private ViewPager mPager;

    private long mLastBackPressedTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        setContentView(R.layout.activity_main);
        mPagerTab = (PagerSlidingTabStrip) findViewById(R.id.main_tabs);
        // 均分
        mPagerTab.setShouldExpand(true);
        //两处硬编码，getResources().getDimensionPixelSize(R.dimen.tab_indicator_height)=2dp
        mPagerTab.setIndicatorHeight(2);
        mPagerTab.setTabBackground(0);
        mPagerTab.setDividerColor(Color.TRANSPARENT);

        mPager = (ViewPager) findViewById(R.id.main_pages);
        // 3个页，不需要重建
        mPager.setOffscreenPageLimit(2);

        setupPager();
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - mLastBackPressedTime >= 2000) {
            mLastBackPressedTime = System.currentTimeMillis();
            Toast.makeText(this.getApplicationContext(),"再按一次退出",Toast.LENGTH_LONG).show();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public void onClick(View view) {
    }


    private void setupPager() {
        mPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return new FeaturesFragment();
                } else if (position == 1) {
                    return new HomeFragment();
                } else if (position == 2) {
                    return new SettingsFragment();
                }

                return null;
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                if (position == 0) {
                    return "功能";
                } else if (position == 1) {
                    return "主页";
                } else if (position == 2) {
                    return "设置";
                }

                return super.getPageTitle(position);
            }
        });
        mPagerTab.setViewPager(mPager);
    }
}
