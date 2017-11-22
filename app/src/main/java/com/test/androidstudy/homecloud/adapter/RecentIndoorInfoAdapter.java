package com.test.androidstudy.homecloud.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.test.androidstudy.homecloud.R;
import com.test.androidstudy.homecloud.bean.RecentIndoorInfoBean;

import java.util.List;

/**
 * Created by vincent on 8/7/16.
 */
public class RecentIndoorInfoAdapter extends BaseAdapter {
    private Context context;
    private List<RecentIndoorInfoBean> recentIndoorInfoBeanList;

    public RecentIndoorInfoAdapter(Context context, List<RecentIndoorInfoBean> recentIndoorInfoBeanList) {
        this.context = context;
        this.recentIndoorInfoBeanList = recentIndoorInfoBeanList;
    }

    @Override
    public int getCount() {
        return recentIndoorInfoBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return recentIndoorInfoBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.message_item, parent, false);
        }

        TextView content1 = (TextView) convertView.findViewById(R.id.message_part1);
        content1.setText(recentIndoorInfoBeanList.get(position).getPart1());

        TextView content2 = (TextView) convertView.findViewById(R.id.message_part2);
        content2.setText(recentIndoorInfoBeanList.get(position).getPart2());

        TextView content3 = (TextView) convertView.findViewById(R.id.message_part3);
        content3.setText(recentIndoorInfoBeanList.get(position).getPart3());
        return convertView;
    }
}
