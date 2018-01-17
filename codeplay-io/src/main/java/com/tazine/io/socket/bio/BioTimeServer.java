package com.tazine.io.socket.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 阻塞IO Socket服务端
 *
 * @author frank
 * @since 1.0.0
 */
public class BioTimeServer {

    public BioTimeServer(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("收到一个 socket");
                SocketHandler handler = new SocketHandler(socket);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BioTimeServer(8080);
    }
}
