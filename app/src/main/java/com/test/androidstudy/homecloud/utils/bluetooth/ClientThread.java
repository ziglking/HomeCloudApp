package com.test.androidstudy.homecloud.utils.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.os.Message;


import java.io.IOException;

/**
 * Created by ljh on 2017/11/21.
 */

public class ClientThread extends Thread {

    private BluetoothSocket mSocket;
    // private BluetoothDevice mDevice;
    private ReadThread mReadThread;
    private Handler mHandler;

    //    public ClientThread(BluetoothSocket mSocket, BluetoothDevice mDevice, ReadThread mReadThread, Handler mHandler) {
    public ClientThread(BluetoothSocket mSocket, ReadThread mReadThread, Handler mHandler) {
        this.mSocket = mSocket;
        //  this.mDevice = mDevice;
        //    this.mReadThread = mReadThread;
        this.mHandler = mHandler;
    }

    public void run() {
        try {
            //mSocket = mDevice.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
            Message msg = new Message();
//            msg.obj = "请稍候，正在连接服务器:" + BluetoothActivity.BlueToothAddress;
            msg.obj = "请稍候，正在连接服务器:" + BluetoothUtil.mAddress;
            msg.what = BluetoothUtil.STATUS_CONNECT;
            mHandler.sendMessage(msg);
            if (!mSocket.isConnected())
                mSocket.connect();

            msg = new Message();
            msg.obj = "已经连接上服务端！可以发送信息。";
            msg.what = BluetoothUtil.STATUS_CONNECT;
            mHandler.sendMessage(msg);
            // 启动接受数据
            mReadThread = new ReadThread(mSocket, mHandler);
            mReadThread.start();
        } catch (IOException e) {
            Message msg = new Message();
            msg.obj = "连接服务端异常！断开连接重新试一试。";
            msg.what = BluetoothUtil.STATUS_CONNECT;
            mHandler.sendMessage(msg);
        }
    }


}
