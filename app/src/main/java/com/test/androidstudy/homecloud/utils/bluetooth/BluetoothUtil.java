package com.test.androidstudy.homecloud.utils.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.test.androidstudy.homecloud.bean.DeviceBean;
import com.test.androidstudy.homecloud.adapter.DeviceListAdapter;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by ljh on 2017/11/21.
 */

public class BluetoothUtil {

    /* 一些常量，代表服务器的名称 */
    public static final String PROTOCOL_SCHEME_RFCOMM = "btspp";
    private static String TAG = "BluetoothUtil";

    // 蓝牙客户端socket
    private static BluetoothSocket mSocket;
    // 设备
    private static BluetoothDevice mDevice;

    private static BluetoothAdapter mBluetoothAdapter;

    // --线程类-----------------
    private static ClientThread mClientThread;
    private static ReadThread mReadThread;

    public static final int STATUS_CONNECT = 0x11;

    public static String mAddress;

    static {
        //初始化adapter,单例模式
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    /**
     * 获取adapter实例
     *
     * @return
     */
    public static BluetoothAdapter getAdapterInstance() {
        if (mBluetoothAdapter == null)
            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        return mBluetoothAdapter;
    }

    /**
     * 根据地址获取当前连接的设备
     *
     * @param address
     * @return
     */
    public static BluetoothDevice getDevice(String address) {
        if (mDevice == null)
            mDevice = mBluetoothAdapter.getRemoteDevice(address);
        return mDevice;
    }

    public static BluetoothSocket getSocket(BluetoothDevice device) throws IOException {
        if (device != null)
            return mDevice.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
        else {
            Log.e(TAG, "getSocket: error when create socket");
            return null;
        }
    }

    /**
     * 获取ClientThread实例
     *
     * @param socket
     * @param device
     * @param readThread
     * @param handler
     * @return
     */
    public static ClientThread getClientThread(BluetoothSocket socket, BluetoothDevice device,
                                               ReadThread readThread, Handler handler) {
        return new ClientThread(socket, readThread, handler);
    }

    /**
     * 初始化连接
     *
     * @param address
     * @param mHandler
     * @throws IOException
     */
    public static void init(String address, Handler mHandler) throws IOException {
        if (mBluetoothAdapter == null)
            mBluetoothAdapter = getAdapterInstance();
        Log.d(TAG, "init: adpater success");
        mDevice = getDevice(address);
        Log.d(TAG, "init: device success：" + mDevice.getAddress());
        mSocket = getSocket(mDevice);
        mSocket.connect();
        Log.d(TAG, "init: mSocket success:" + mSocket.isConnected());
        mClientThread = getClientThread(mSocket, mDevice, mReadThread, mHandler);
        Log.d(TAG, "init: mClientThread success");
        mClientThread.start();
        Log.d(TAG, ": mClientThread start success");
    }

    public static void shutdownClient() {
        new Thread() {
            public void run() {
                if (mClientThread != null) {
                    mClientThread.interrupt();
                    mClientThread = null;
                }
                if (mReadThread != null) {
                    mReadThread.interrupt();
                    mReadThread = null;
                }
                if (mSocket != null) {
                    try {
                        mSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mSocket = null;
                }
            }

            ;
        }.start();
    }

    public static void sendMessageHandle(String msg, Context context, ListView mListView,
                                         ArrayList<DeviceBean> mDatas, DeviceListAdapter mAdapter) {
        if (mSocket == null) {
            Toast.makeText(context, "没有连接", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            OutputStream os = mSocket.getOutputStream();
            os.write(msg.getBytes());

            //mDatas.add(new DeviceBean(msg, false));
            // mAdapter.notifyDataSetChanged();
            // mListView.setSelection(mDatas.size() - 1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
