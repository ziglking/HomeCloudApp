package com.test.androidstudy.homecloud.utils.bluetooth;

/**
 * Created by ljh on 2017/11/22.
 * Command like YTAA LLLL 0000 0C0F,
 * Y:音箱
 * T：电视
 * A：空调
 * L：灯
 * F：报警器
 * C：控制位，0为关指令，1为开指令
 */

public class CommandUtilDep {

    public static final int TEMPERATURE = 0;
    public static final int HUMIDITY = 1;
    public static final int STATUS = 2;

    /**
     * 音箱，Y
     */
    public static final int SPEAKER = 0b1000_0000_0000_0000;
    /**
     * 电视：T
     */
    public static final int TELEVISION = 0b0100_0000_0000_0000;
    /**
     * 空调：A
     */
    public static final int AIRCONDITION_1 = 0b0001_0000_0000_0000;
    public static final int AIRCONDITION_2 = 0b0010_0000_0000_0000;
    /**
     * 灯：L
     */
    public static final int LIGHT_1 = 0b0000_0001_0000_0000;
    public static final int LIGHT_2 = 0b0000_0010_0000_0000;
    public static final int LIGHT_3 = 0b0000_0100_0000_0000;
    public static final int LIGHT_4 = 0b0000_1000_0000_0000;
    /**
     * 防盗：F
     */
    public static final int ALARM = 0b0000_0000_0000_0001;

    public static final int ALL = 0b1111_1111_1111_1011;


    public static Integer getCloseCode(Integer id) {
        int close = 0b1111_1111_1111_1011;
        return close - id;
    }

    public static Integer getOpenCode(Integer id) {
        int open = 0b0000_0000_0000_0100;
        return open + id;
    }

}
