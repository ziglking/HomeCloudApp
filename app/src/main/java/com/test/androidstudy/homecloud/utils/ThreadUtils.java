package com.test.androidstudy.homecloud.utils;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

/**
 * Created by tangjie on 8/23/16.
 */
public final class ThreadUtils {

    private static Handler sHandler = new Handler(Looper.getMainLooper());

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void runOnMainThread(@NonNull Runnable runnable) {
        sHandler.post(runnable);
    }

    public static void runOnMainThreadDelay(@NonNull Runnable runnable, int delayMillis) {
        sHandler.postDelayed(runnable, delayMillis);
    }
}
