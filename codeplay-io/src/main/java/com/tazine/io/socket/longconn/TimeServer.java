package com.tazine.io.socket.longconn;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * TimeServer
 *
 * @author frank
 * @date 2018/05/16
 */
public class TimeServer {

    public void bind(int port) throws InterruptedException {

        /* 配置服务端的 NIO 线程组 */
        // NioEventLoopGroup类 是个线程组，包含一组 NIO 线程，用于网络事件的处理（实际上它就是 Reactor 线程组）
        // 服务端接收客户端连接线程组
        EventLoopGroup connectGroup = new NioEventLoopGroup();
        // 进行 SocketChannel 网络读写的线程组
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // ServerBootstrap 类，是启动 NIO 服务器的辅助启动类
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(connectGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChildChannelHandler());

            // 绑定端口，同步等待成功
            ChannelFuture f = bootstrap.bind(port).sync();

            // 等待服务端监听端口关闭
            f.channel().closeFuture().sync();
        }finally {
            connectGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel>{

        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast(new TimeServerHandler());
        }
    }

    public static void main(String[] args) throws InterruptedException {

        int port = 8080;
        new TimeServer().bind(port);
    }

}
