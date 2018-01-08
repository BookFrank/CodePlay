package com.tazine.thread.threadlocal.cases.connection;

/**
 * Created by lina on 2018/1/8.
 *
 * @author frank
 * @since 1.0.0
 */
public class ClientThread implements Runnable {

//    private PlayerService playerService;
//
//    public ClientThread(PlayerService playerService) {
//        this.playerService = playerService;
//    }

    @Override
    public void run() {
        PlayerService playerService = new PlayerServiceImpl();
        System.out.println(Thread.currentThread().getName());
        playerService.updatePlayerNum(1, 8);
    }
}
