package com.tazine.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by lina on 2017/11/17.
 */
public class TimeServer {


    public static void main(String[] args) throws IOException {
        int port = 8080;

        ServerSocket serverSocket = null;
        try {

            serverSocket = new ServerSocket(port);
            System.out.println(" The time server starts at port: " + port);
            while (true){
                Socket socket = serverSocket.accept();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != serverSocket){
                System.out.println("The time server closed.");
                serverSocket.close();
            }
        }
    }



}
