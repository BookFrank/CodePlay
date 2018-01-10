package com.tazine.io.netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * SocketHandler
 *
 * @author frank
 * @since 1.0.0
 */
public class SocketHandler implements Runnable {

    private Socket socket;

    public SocketHandler(Socket socket) throws IOException {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        PrintWriter writer = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            String line = null;
            while ((line = br.readLine()) != null){
                System.out.println("收到消息：");
                System.out.println("    " + line);
                if ("exit".equalsIgnoreCase(line)){
                    writer.println("bye");
                    break;
                }else {
                    writer.println(new Date().toString());
                }
            }
            System.out.println("0-------0");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("退出连接");
            try {
                if (socket != null) {
                    socket.close();
                    socket = null;
                }
                if (br != null) {
                    br.close();
                }
                if (writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
