package com.tazine.base.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * java.lang.Runtime
 *
 * @author frank
 * @date 2018/02/28
 */
public class RuntimePractice {

    public static void main(String[] args) {

        System.out.println("定时任务开始");

        Process process = null;
        try {
            process = Runtime.getRuntime().exec("phantomjs -v");

            InputStream inputStream = process.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            String s = br.readLine();
            while (s != null) {
                System.out.println(s);
                s = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != process){
                process.destroy();
            }
        }
    }
}
