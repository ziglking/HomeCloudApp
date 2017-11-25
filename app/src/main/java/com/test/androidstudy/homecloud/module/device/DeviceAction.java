package com.test.androidstudy.homecloud.module.device;

import android.support.annotation.NonNull;

import com.test.androidstudy.homecloud.R;
import com.test.androidstudy.homecloud.bean.DeviceListBean;
import com.test.androidstudy.homecloud.net.BaseRequest;
import com.test.androidstudy.homecloud.net.HttpCallback;
import com.test.androidstudy.homecloud.utils.ToastWrapper;
import com.test.androidstudy.homecloud.AppProfile;
import com.test.androidstudy.homecloud.exception.ApiException;

import java.io.IOException;
import java.util.List;
/**
 * Created by BumIce on 2017/7/17.
 */

public class DeviceAction {
    //
    public static  List<com.test.androidstudy.homecloud.bean.DeviceBean> getDevices(String token, String phone) {
        try {
            return ((DeviceListBean) new GetDevicesHttpTask(token, phone).execute().data).getSearchInfos();
        } catch (IOException e) {
            throw new ApiException(e);
        }

    }


    public static void addDevice(@NonNull String phone, @NonNull String token, @NonNull int id, @NonNull String name) {
        AddDeviceHttpTask task = new AddDeviceHttpTask(phone, token, id, name);
        task.enqueue(new HttpCallback() {
            @Override
            public void onResponse(BaseRequest request, Object data) {
//                UIUtils.showToast(R.string.collection_add_success);
                ToastWrapper.makeLongToast(AppProfile.getContext().getString(R.string.device_add_success));
            }

            @Override
            public void onFailure(BaseRequest request, Exception e, int code, String message) {
//                UIUtils.showToast(message);
                ToastWrapper.makeLongToast(message);
            }
        });
    }


    public static void delDevice(String token, int id, final IDelDevice delCollection) {
        DelDeviceHttpTask task = new DelDeviceHttpTask(token, id);
        task.enqueue(new HttpCallback() {
            @Override
            public void onResponse(BaseRequest request, Object data) {
                if (delCollection != null) {
                    delCollection.onSuccess();
                }
            }

            @Override
            public void onFailure(BaseRequest request, Exception e, int code, String message) {
                if (delCollection != null) {
                    delCollection.onFail(code, message);
                }
            }
        });
    }

    public interface IDelDevice {
        void onSuccess();

        void onFail(int code, String message);
    }
}
