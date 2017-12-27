package com.tazine.design.adapter;

/**
 * Created by lina on 2017/12/27.
 *
 * @author frank
 * @since 1.0.0
 */
public class SocketAdapter implements HkSocketInterface{


    private GbSocketInterface gbSocket;

    public SocketAdapter(GbSocketInterface gbSocket) {
        this.gbSocket = gbSocket;
    }

    @Override
    public void powerWithThree() {
        gbSocket.powerWithTwo();
    }
}
