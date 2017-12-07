package com.tazine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取局域网所有ip, 有问题 TODO
 */
public class PingIp {

    public static void main(String[] args) {
        Thread thread = new Thread(new PingIpThread("172.20.207.30"));
        thread.start();
    }
}

class PingIpThread implements Runnable{

    public String ip;

    private Map pingMap = new HashMap<String,String>();

    public PingIpThread(String ip) {
        this.ip = ip;
    }

    public void run() {
        try {
            Process process = Runtime.getRuntime().exec("ping " + ip + "-w 280 -n 1");

            InputStream inputStream = process.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(reader);

            String line;
            while ((line = br.readLine()) != null && !line.equals("")){
                if (line.substring(0,2).equals("来自") || (line.length()>10 && line.substring(0,10).equals("Reply from"))){
                    pingMap.put(line,"true");
                }
            }
            System.out.println(pingMap.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
