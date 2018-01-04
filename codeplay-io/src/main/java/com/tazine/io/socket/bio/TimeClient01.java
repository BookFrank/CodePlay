package com.tazine.io.socket.bio;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by lina on 2018/1/4.
 *
 * @author frank
 * @since 1.0.0
 */
public class TimeClient01 {


    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1",8080);

            socket.getOutputStream().write("Hello World".getBytes());

            socket.getOutputStream().flush();

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
