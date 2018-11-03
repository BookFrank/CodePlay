package com.tazine.io.socket.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * InetAddress 用来标示网络上的硬件资源，表示互联网协议地址（IP）
 *
 * @author frank
 * @date 2017/10/31
 */
public class InetAddressFeature {

    public static void main(String[] args) throws UnknownHostException {

        InetAddress address = InetAddress.getLocalHost();
        System.out.println("InetAddress.getLocalHost() : " + address);
        System.out.println("InetAddress.getLoopBackAddress() : " + InetAddress.getLoopbackAddress());

        System.out.println("address.getHostName() : " + address.getHostName());
        System.out.println("address.getHostAddress() : " + address.getHostAddress());

        // 获取字节数组形式额 IP 地址
        byte[] bytes = address.getAddress();
        System.out.println("address.getAddress() : " + Arrays.toString(bytes));

        System.out.println(InetAddress.getByName("xiaofang"));

    }

}
