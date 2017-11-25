package com.test.androidstudy.homecloud.module.device;

import android.support.annotation.NonNull;

import com.test.androidstudy.homecloud.net.FormRequest;
import com.test.androidstudy.homecloud.net.HttpMethod;

/**
 * Created by BumIce on 2017/7/17.
 */

public class AddDeviceHttpTask extends FormRequest {
    public AddDeviceHttpTask(@NonNull String phone, @NonNull String token, @NonNull int id, @NonNull String name) {
        super();
        mBodyMap.put("phone", phone);
        mBodyMap.put("token", token);
        mBodyMap.put("id", id);
        mBodyMap.put("name", name);
    }

    @Override
    public String getApi() {
        return "device/addDevice.do";
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
