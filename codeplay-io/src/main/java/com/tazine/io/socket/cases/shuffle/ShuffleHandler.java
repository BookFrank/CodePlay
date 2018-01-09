package com.tazine.io.socket.cases.shuffle;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

/**
 * ShuffleHandler
 *
 * @author frank
 * @since 1.0.0
 */
public class ShuffleHandler implements Runnable {

    private Socket socket;
    private PrintWriter writer;

    private Integer[] myCards;

    public ShuffleHandler(Socket socket, int i, Integer[] cards) {
        this.socket = socket;
        myCards = Arrays.copyOfRange(cards, (i - 1) * 4, 4 * i);
        for (int t : myCards) {
            System.out.print(t + "-");
        }
    }

    @Override
    public void run() {
        try {
            writer = new PrintWriter(socket.getOutputStream(), true);
            for (int i : myCards) {
                writer.println(i);
            }
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
