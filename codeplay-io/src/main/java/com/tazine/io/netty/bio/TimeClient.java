package com.tazine.io.netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by lina on 2018/1/10.
 *
 * @author frank
 * @since 1.0.0
 */
public class TimeClient {

    public TimeClient(String host, int port) throws IOException {

        BufferedReader br = null;
        PrintWriter writer = null;
        Socket socket = null;
        try {
            socket = new Socket(host, port);
            writer = new PrintWriter(socket.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                writer.println(sc.next());
                String line = br.readLine();
                if (line.equalsIgnoreCase("bye")) {
                    break;
                } else {
                    System.out.println("  " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("退出当前会话");
            if (br != null) {
                br.close();
            }
            if (socket != null) {
                socket.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new TimeClient("127.0.0.1", 8080);
    }
}