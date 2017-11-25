package com.test.androidstudy.homecloud.bean;

import java.io.Serializable;

/**
 * Created by wangxiang on 2017/11/25.
 */

public class DeviceBean implements Serializable{
    public int id;
    public String name;
    public int status;
    public String updateTime;

    public DeviceBean(int id, String name, int status, String updateTime) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.updateTime = updateTime;
    }
}
