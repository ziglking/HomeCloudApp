package com.test.androidstudy.homecloud.module.device;

import com.test.androidstudy.homecloud.net.FormRequest;
import com.test.androidstudy.homecloud.net.HttpMethod;

/**
 * Created by wangxiang on 2017/11/25.
 */

public class UpdateDeviceHttpTask extends FormRequest{
    public UpdateDeviceHttpTask(String token, int id) {
        super();
        mBodyMap.put("token", token);
        mBodyMap.put("id",id);
    }

    @Override
    public String getApi() {
        return "device/updateDeviceById.do";
    }

    @Override
    public int getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    public Class getModelClass() {
        return null;
    }
}
