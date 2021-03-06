package com.tazine.io.socket.faio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TimeServer
 *
 * @author frank
 * @date 2017/11/18
 */
public class TimeServer {

    public static void main(String[] args) {

        int port = 8080;

        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(port);

            while (true) {
                socket = serverSocket.accept();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
