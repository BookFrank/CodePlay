package com.tazine.io.socket.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Client
 *
 * @author frank
 * @since 1.0.0
 */
public class Client {

    public Client(String host, int port) throws IOException {

        Socket socket = null;
        BufferedReader buffer = null;
        PrintWriter writer = null;
        try {
            socket = new Socket(host, port);
            writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("hello server");
            System.out.println("发送消息: hello server");
            buffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = buffer.readLine();
            System.out.println("收到消息：" + line);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (socket != null){
                socket.close();
            }
            if (buffer != null){
                buffer.close();
            }

        }
    }

    public static void main(String[] args) throws IOException {
        new Client("127.0.0.1", 8080);
    }
}
