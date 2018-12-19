package com.tazine.thread.concurrent.threadlocal.cases.connection;

/**
 * ClientThread
 *
 * @author frank
 * @date 2017/12/27
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
