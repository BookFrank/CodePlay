package com.tazine.io.socket.longconn.cases;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author jiaer.ly
 * @date 2018/05/16
 */
public class LongServer {



    public static void listen(int port){

        try {

            ServerSocket serverSocket = new ServerSocket(port);

            while (true){
                Socket socket = serverSocket.accept();

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {



    }
}
