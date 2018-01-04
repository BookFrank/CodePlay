package com.tazine.io.socket.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 阻塞IO Socket服务端
 *
 * @author frank
 * @since 1.0.0
 */
public class TimeServer {


    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();

            System.out.println("收到请求");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
