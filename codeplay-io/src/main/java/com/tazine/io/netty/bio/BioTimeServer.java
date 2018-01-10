package com.tazine.io.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Blocking IO
 *
 * @author frank
 * @since 1.0.0
 */
public class BioTimeServer {

    public BioTimeServer(int port) throws IOException {
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            while (true){
                Socket socket = server.accept();
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != server){
                server.close();
                server = null;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new BioTimeServer(8080);
    }
}
