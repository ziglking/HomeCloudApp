package com.test.androidstudy.homecloud.bean;

import java.io.Serializable;
import java.util.List;

public class DeviceListBean implements Serializable{

    private static final long serialVersionUID = 1864844513850389196L;

    private List<DeviceBean> mSearchInfos;

    public List<DeviceBean> getSearchInfos() {
        return mSearchInfos;
    }

    public void setSearchInfos(List<DeviceBean> searchInfos) {
        this.mSearchInfos = searchInfos;
    }

    public List getDataset() {
        return getSearchInfos();
    }

}