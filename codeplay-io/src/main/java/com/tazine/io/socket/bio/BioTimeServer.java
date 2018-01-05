package com.tazine.io.socket.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 阻塞IO Socket服务端
 *
 * @author frank
 * @since 1.0.0
 */
public class BioTimeServer {

    private BufferedReader reader;
    private PrintWriter writer;

    public BioTimeServer(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);

            while (true){
                Socket socket = serverSocket.accept();
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("收到消息：");
                String line;
                while ((line = reader.readLine()) != null){
                    System.out.print("  " + line);
                }
                System.out.println();
                System.out.println("发送消息：");
                writer = new PrintWriter(socket.getOutputStream());
                System.out.println("  你说的什么我听不懂啊。。。");
                writer.println("  你说的什么我听不懂啊。。。");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BioTimeServer(8080);
    }
}
