package com.test.androidstudy.homecloud.utils.bluetooth;

/**
 * Created by ljh on 2017/11/23.
 */

public class CommandUtil {

    public static final int TEMPERATURE = 0;
    public static final int HUMIDITY = 1;
    public static final int STATUS = 2;


//    /**
//     * 灯：L
//     */
//    public static final int LIGHT_1 = 0;
//    public static final int LIGHT_2 = 1;
//    public static final int LIGHT_3 = 2;
//    public static final int LIGHT_4 = 3;
//
//    /**
//     * 空调：A
//     */
//    public static final int AIRCONDITION_1 = 4;
//    public static final int AIRCONDITION_2 = 5;
//
//    /**
//     * 电视：T
//     */
//    public static final int TELEVISION = 6;
//
//    /**
//     * 音箱，Y
//     */
//    public static final int SPEAKER = 7;
//
//    public static final int ALL = 8;
//    /**
//     * 防盗：F
//     */
//    public static final int ALARM = 9;

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

    public static final int ALL = 0;


    public static char getCloseCode(Integer id) {

        switch (id) {
            case LIGHT_1:
                return 'a';
            case LIGHT_2:
                return 'b';
            case LIGHT_3:
                return 'c';
            case LIGHT_4:
                return 'd';
            case AIRCONDITION_1:
                return 'e';
            case AIRCONDITION_2:
                return 'f';
            case TELEVISION:
                return 'g';
            case SPEAKER:
                return 'h';
            case ALARM:
                return 'j';
            case ALL:
                return 'i';

        }
        //异常指令
        return 's';
    }

    public static char getOpenCode(Integer id) {

        switch (id) {
            case LIGHT_1:
                return 'a';
            case LIGHT_2:
                return 'b';
            case LIGHT_3:
                return 'c';
            case LIGHT_4:
                return 'd';
            case AIRCONDITION_1:
                return 'e';
            case AIRCONDITION_2:
                return 'f';
            case TELEVISION:
                return 'g';
            case SPEAKER:
                return 'h';
            case ALARM:
                return 'j';
            case ALL:
                return 'i';

        }
        //异常指令
        return 's';
    }


}
