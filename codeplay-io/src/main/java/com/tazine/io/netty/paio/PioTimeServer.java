package com.tazine.io.netty.paio;

import com.tazine.io.netty.bio.SocketHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Pseudo-Async IO
 *
 * @author frank
 * @since 1.0.0
 */
public class PioTimeServer {

    public PioTimeServer(int port) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            PioHandlerPool pool = new PioHandlerPool(5, 5);
            while (true) {
                Socket socket = server.accept();
                pool.submit(new SocketHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PioTimeServer(8080);
    }
}
