package com.test.androidstudy.homecloud.bean;

/**
 * Created by wangxiang on 2017/11/25.
 */

public class BluetoothDeviceBean {
    public String message;
    public boolean isReceive;

    public BluetoothDeviceBean(String name, boolean isOpen){
        this.message = name;
        this.isReceive = isOpen;
    }

}
