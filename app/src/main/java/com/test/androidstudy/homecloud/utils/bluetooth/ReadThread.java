package com.test.androidstudy.homecloud.utils.bluetooth;

import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created by ljh on 2017/11/21.
 */

public class ReadThread extends Thread {

    private BluetoothSocket mSocket;
    private Handler mHandler;
    private static String TAG = "ReadThread";

    public ReadThread(BluetoothSocket mSocket, Handler mHandler) {
        this.mSocket = mSocket;
        this.mHandler = mHandler;

    }

    public void run() {
        byte[] buffer = new byte[1024];
        int bytes;
        InputStream is = null;
        try {
            is = mSocket.getInputStream();
            InputStreamReader isReader = new InputStreamReader(is);
            BufferedReader bufferReader = new BufferedReader(isReader);
            while (true) {
                String s;
                if (bufferReader.ready() && !(s = bufferReader.readLine()).equals("")) {
                    Message msg = new Message();
                    msg.obj = s;
                    msg.what = 1;
                    mHandler.sendMessage(msg);
                    Log.d(TAG, "run: outStr:" + s);
                    Integer[] datas = DataUtil.parseData(s);
                    Map<Integer, Integer> statusMap = DataUtil.parseStatus(datas[DataUtil.STATUS]);
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            Log.e(TAG, "run: sm go wrong");
        } finally {
            try {
                is.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }
}

