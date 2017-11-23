package com.test.androidstudy.homecloud.utils.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.os.Message;


import java.io.IOException;
import java.util.UUID;

/**
 * Created by ljh on 2017/11/21.
 */

public class ServerThread extends Thread {
    private BluetoothServerSocket mServerSocket;
    private BluetoothAdapter mBluetoothAdapter;
    private Handler mHandler;
    private ReadThread mReadThread;
    private BluetoothSocket mSocket;

    public ServerThread(BluetoothServerSocket mServerSocket, BluetoothAdapter mBluetoothAdapter,
                        Handler mHandler, ReadThread mReadThread, BluetoothSocket mSocket) {
        this.mServerSocket = mServerSocket;
        this.mBluetoothAdapter = mBluetoothAdapter;
        this.mHandler = mHandler;
        this.mReadThread = mReadThread;
        this.mSocket = mSocket;
    }

    public void run() {
        try {
            // 创建一个蓝牙服务器 参数分别：服务器名称、UUID
            mServerSocket = mBluetoothAdapter.listenUsingRfcommWithServiceRecord(BluetoothUtil.PROTOCOL_SCHEME_RFCOMM,
                    UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));

            Message msg = new Message();
            msg.obj = "请稍候，正在等待客户端的连接...";
            msg.what = BluetoothUtil.STATUS_CONNECT;
            mHandler.sendMessage(msg);

				/* 接受客户端的连接请求 */
            mSocket = mServerSocket.accept();

            msg = new Message();
            msg.obj = "客户端已经连接上！可以发送信息。";
            msg.what = BluetoothUtil.STATUS_CONNECT;
            mHandler.sendMessage(msg);
            // 启动接受数据
            mReadThread = new ReadThread(mSocket, mHandler);
            mReadThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}