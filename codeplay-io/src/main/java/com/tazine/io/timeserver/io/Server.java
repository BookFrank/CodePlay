package com.tazine.io.timeserver.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by lina on 2017/12/28.
 *
 * @author frank
 * @since 1.0.0
 */
public class Server {

    public static void main(String[] args) throws IOException {


        ServerSocket serverSocket = new ServerSocket(8888);

        Socket socket =  serverSocket.accept();



    }

}
