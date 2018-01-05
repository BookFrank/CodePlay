package com.tazine.io.socket.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * SocketClient
 *
 * @author frank
 * @since 1.0.0
 */
public class TimeClient01 {

    private BufferedReader br;

    private PrintWriter writer;

    private Scanner scanner;

    public TimeClient01(String host, int port) {

        try {
            Socket socket = new Socket(host, port);


            scanner = new Scanner(System.in);

            while (true) {
                writer = new PrintWriter(socket.getOutputStream());
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String input = scanner.nextLine();
                System.out.println("发送信息：");
                System.out.println("  " + input);
                writer.write(input);
                writer.flush();
                System.out.println("收到回应：");
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.print("  " + line);
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new TimeClient01("127.0.0.1", 8080);
    }

}
