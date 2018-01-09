package com.tazine.io.socket.cases.shuffle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Gambler
 *
 * @author frank
 * @since 1.0.0
 */
public class Gambler {

    private BufferedReader br;

    public Gambler(String host, int port) throws IOException {

        Socket socket = new Socket(host, port);
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line = null;
        while ((line = br.readLine()) != null){
            System.out.print(line + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        new Gambler("127.0.0.1", 2001);
        new Gambler("127.0.0.1", 2001);
        new Gambler("127.0.0.1", 2001);
        new Gambler("127.0.0.1", 2001);
    }
}
