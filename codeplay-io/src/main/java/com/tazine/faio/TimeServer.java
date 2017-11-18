package com.tazine.faio;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by lina on 2017/11/18.
 */
public class TimeServer {

    public static void main(String[] args) {

        int port = 8080;

        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(port);

            while (true){
                socket = serverSocket.accept();
            }



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }


    }
}
