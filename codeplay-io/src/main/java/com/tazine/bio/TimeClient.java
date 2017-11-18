package com.tazine.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by lina on 2017/11/18.
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 8080;
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter writer = null;

        try {
            socket = new Socket("127.0.0.1", port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("QUERY TIME ORDER");
            String resp = in.readLine();
            System.out.println("Now is the response" + resp);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
