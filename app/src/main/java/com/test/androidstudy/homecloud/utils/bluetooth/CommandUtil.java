package com.test.androidstudy.homecloud.utils.bluetooth;

/**
 * Created by ljh on 2017/11/23.
 */

public class CommandUtil {

    public static final int TEMPERATURE = 0;
    public static final int HUMIDITY = 1;
    public static final int STATUS = 2;


    /**
     * 灯：L
     */
    public static final int LIGHT_1 = 0;
    public static final int LIGHT_2 = 1;
    public static final int LIGHT_3 = 2;
    public static final int LIGHT_4 = 3;

    /**
     * 空调：A
     */
    public static final int AIRCONDITION_1 = 4;
    public static final int AIRCONDITION_2 = 5;

    /**
     * 电视：T
     */
    public static final int TELEVISION = 6;

    /**
     * 音箱，Y
     */
    public static final int SPEAKER = 7;

    public static final int ALL = 8;
    /**
     * 防盗：F
     */
    public static final int ALARM = 9;


    public static char getCloseCode(Integer id) {

        return (char) ('A' + id);
    }

    public static char getOpenCode(Integer id) {

        return (char) ('a' + id);
    }


}
