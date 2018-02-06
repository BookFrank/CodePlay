package com.tazine.io.socket.test;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket Server
 *
 * @author frank
 * @since 1.0.0
 */
public class Server {

    public Server(int port) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            while (true){
                Socket socket = server.accept();
                new SocketHandler(socket).start();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server(8080);
    }
}
