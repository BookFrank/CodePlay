package com.tazine.io.socket.cases.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 聊天服务端
 *
 * @author frank
 * @since 1.0.0
 */
public class ChatTcpServer {

    public ChatTcpServer(int port, String name) throws IOException {
        ServerSocket server = new ServerSocket(port);
        Socket client = server.accept();
        new ChatTcpSocket(name, client);
        server.close();
    }

    public static void main(String[] args) throws IOException {
        new ChatTcpServer(2001, "PDD");
    }
}
