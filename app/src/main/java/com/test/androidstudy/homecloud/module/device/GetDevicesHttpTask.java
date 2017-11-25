package com.test.androidstudy.homecloud.module.device;

import com.test.androidstudy.homecloud.bean.DeviceListBean;
import com.test.androidstudy.homecloud.net.FormRequest;
import com.test.androidstudy.homecloud.net.HttpMethod;

/**
 * Created by BumIce on 2017/7/17.
 */

public class GetDevicesHttpTask extends FormRequest {
    public GetDevicesHttpTask(String token, String phone) {
        super();
        mBodyMap.put("token", token);
        mBodyMap.put("phone", phone);
    }

    @Override
    public String getApi() {
        return "device/listDevicesByPhone.do";
    }

    @Override
    public int getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    public Class getModelClass() {
        return DeviceListBean.class;
    }
}
