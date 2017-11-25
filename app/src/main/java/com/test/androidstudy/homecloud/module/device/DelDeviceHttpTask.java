package com.test.androidstudy.homecloud.module.device;

import com.test.androidstudy.homecloud.net.FormRequest;
import com.test.androidstudy.homecloud.net.HttpMethod;

/**
 * Created by BumIce on 2017/7/17.
 */

public class DelDeviceHttpTask extends FormRequest {
    public DelDeviceHttpTask(String token, int id) {
        super();
        mBodyMap.put("token", token);
        mBodyMap.put("id",id);
    }

    @Override
    public String getApi() {return "device/deleteDeviceById.do";}

    @Override
    public int getHttpMethod() {return HttpMethod.POST;}

    @Override
    public Class getModelClass() {return null;}
}
