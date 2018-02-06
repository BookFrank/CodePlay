package com.tazine.io.socket.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * SocketHandler
 *
 * @author frank
 * @since 1.0.0
 */
public class SocketHandler extends Thread {

    private Socket socket;

    public SocketHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        PrintWriter writer = null;
        BufferedReader buffer = null;
        try {
            buffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = buffer.readLine();
            System.out.println("服务端收到消息 " + line);
            writer = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("发送消息：hello world");
            writer.write("hello world");
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
}
