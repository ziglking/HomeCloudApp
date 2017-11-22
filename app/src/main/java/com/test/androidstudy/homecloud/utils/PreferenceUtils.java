package com.test.androidstudy.homecloud.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.test.androidstudy.homecloud.AppProfile;
import com.test.androidstudy.homecloud.ExerciseConst;

/**
 * Created by netease on 16/11/27.
 */

public class PreferenceUtils {
    private static SharedPreferences getMainPreference() {
        return AppProfile.getContext().getSharedPreferences("main_preference", Context.MODE_PRIVATE);
    }

    public static void saveDeviceId(String deviceId) {
        getMainPreference().edit().putString(ExerciseConst.PREFERENCE_KEY.DEVICEID, deviceId).apply();
    }

    public static String getDeviceId() {
        return getMainPreference().getString(ExerciseConst.PREFERENCE_KEY.DEVICEID, "");
    }
}
