package com.test.androidstudy.homecloud.utils.bluetooth;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ljh on 2017/11/22.
 */

public class DataUtil {

    public static final int TEMPERATURE = 0;
    public static final int HUMIDITY = 1;
    public static final int STATUS = 2;

    /**
     * 音箱，Y
     */
    public static final int SPEAKER = 15;
    /**
     * 电视：T
     */
    public static final int TELEVISION = 14;
    /**
     * 空调：A
     */
    public static final int AIRCONDITION_1 = 12;
    public static final int AIRCONDITION_2 = 13;
    /**
     * 灯：L
     */
    public static final int LIGHT_1 = 8;
    public static final int LIGHT_2 = 9;
    public static final int LIGHT_3 = 10;
    public static final int LIGHT_4 = 11;
    /**
     * 防盗：F
     */
    public static final int ALARM = 2;

    private static final String TAG = "DataUtil";


    /**
     * @param data
     * @throws Exception 解析异常
     */
    public static Integer[] parseData(String data) throws Exception {
        String[] dataArr = data.split(":");

        //数据格式为：T:H:FLAG
        //温度
        int temperature = Integer.parseInt(dataArr[TEMPERATURE]);
        //湿度
        int humidity = Integer.parseInt(dataArr[HUMIDITY]);
        //控制位
        int status = Integer.parseInt(dataArr[STATUS]);
        Log.d(TAG, "parseData: temperature:" + temperature + ",humidity:" + humidity + ",status:" + status);
        return new Integer[]{temperature, humidity, status};
    }

    public static Map<Integer, Integer> parseStatus(Integer status) {
        Map<Integer, Integer> statusMap = new HashMap<>();
        String binaryString = Integer.toBinaryString(status);
        StringBuilder builder = new StringBuilder(binaryString);
        //补全16位
        for (int i = binaryString.length(); i < 16; i++)
            builder.insert(0, "0");
        //翻转，方便取ID
        builder.reverse();
        for (int i = 0; i < builder.length(); i++) {
            Log.d(TAG, "parseStatus: " + i + ":" + builder.charAt(i));
            statusMap.put(i, Integer.valueOf(builder.charAt(i)));
        }
        return statusMap;
    }
}
