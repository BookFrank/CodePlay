package com.tazine.io.socket.cases.shuffle;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 赌场发牌荷官
 *
 * @author frank
 * @since 1.0.0
 */
public class Casino {

    private static Integer[] cards = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
            23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41,
            42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52
    };

    public Casino(int port) throws IOException {
        ServerSocket server = new ServerSocket(port);
        shuffle();
        int i = 1;
        while (true) {
            Socket socket = server.accept();
            new Thread(new ShuffleHandler(socket, i, cards)).start();
            i++;
        }
    }

    private void shuffle() {
        List<Integer> list = Arrays.asList(cards);
        Collections.shuffle(list);

        cards = list.toArray(new Integer[cards.length]);

        for (int i : cards) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        Casino casino = new Casino(2001);
    }
}
