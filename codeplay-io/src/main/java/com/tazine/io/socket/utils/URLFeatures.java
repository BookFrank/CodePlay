package com.tazine.io.socket.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * java.net.URL
 *
 * @author frank
 * @since 1.0.0
 */
public class URLFeatures {
    public static void main(String[] args) {

        try {
            URL tazine = new URL("http://www.tazine.com");

            URL url = new URL(tazine, "/index.html?user=frank");

            System.out.println(tazine.getProtocol());
            System.out.println(tazine.getAuthority());
            System.out.println(tazine.getHost());
            // 如果未指定端口号，返回协议默认端口，
            // java.net.URL.getPort()规定，若URL的实例未申明（省略）端口号
            System.out.println(tazine.getPort()); // -1
            System.out.println(tazine.getUserInfo());
            System.out.println("查询字符串" + url.getQuery());


            // 通过 URL 对象的openstream()方法可以得到指定资源的输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(tazine.openStream(), "utf-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
