package com.tazine.codeplay.version;

import com.google.common.collect.Lists;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

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

        NbaPlayer p1 = new NbaPlayer("kobe", 24);
        NbaPlayer p2 = new NbaPlayer("james", 23);
        NbaPlayer p3 = new NbaPlayer("kwahi", 3);

        // 会报错
        List<NbaPlayer> players = Lists.newArrayList(p1, p2, p3);
        players.forEach(v -> {
            if (v.getNum() == 23){
                players.remove(v);
            }
        });
        System.out.println(players.size());
    }
}
