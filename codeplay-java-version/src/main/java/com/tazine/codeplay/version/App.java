package com.tazine.codeplay.version;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * App
 *
 * @author frank
 * @date 2018/03/21
 */
public class App {

    public static void main(String[] args) throws UnknownHostException {

        // 通过 InetAddress 获取本机IP与计算机名
        String ip = InetAddress.getLocalHost().getHostAddress();
        String name = InetAddress.getLocalHost().getHostName();

        System.out.println("IP地址：" + ip);
        System.err.println("计算机名：" + name);
    }
}
