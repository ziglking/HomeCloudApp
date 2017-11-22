package com.test.androidstudy.homecloud.bean;

/**
 * Created by wangxiang on 2017/11/19.
 * 这个类用来表示每日温度等信息记录
 */

public class RecentIndoorInfoBean {
    private String part1;
    private String part2;
    private String part3;

    public RecentIndoorInfoBean(String part1, String part2, String part3)
    {
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
    }

    public String getPart1() {
        return part1;
    }

    public String getPart2() {
        return part2;
    }

    public String getPart3() {
        return part3;
    }
}
