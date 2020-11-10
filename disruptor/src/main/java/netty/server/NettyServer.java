package netty.server;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.dsl.ProducerType;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import netty.client.NettyClient;
import netty.common.MarashallingCodeCFactory;
import netty.distruptor.MessageConsumer;
import netty.distruptor.MessageConsumerImplServer;
import netty.distruptor.RingBufferWorkerPoolFactory;

/**
 * @program: disruptor
 * @description:
 * @author: HuRan
 * @create: 2020-11-08 21:28
 */
public class NettyServer {
    public NettyServer() {
        EventLoopGroup boosGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            final ServerBootstrap group = serverBootstrap.group(boosGroup, workGroup);
            group.channel(NioServerSocketChannel.class)
                    //TCP accpty queue block queue
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .option(ChannelOption.RCVBUF_ALLOCATOR, AdaptiveRecvByteBufAllocator.DEFAULT)
                    .handler(new LoggingHandler(LogLevel.DEBUG))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(MarashallingCodeCFactory.buildMarshallingDecoder());
                            ch.pipeline().addLast(MarashallingCodeCFactory.buildMarshallingEncoder());
                            ch.pipeline().addLast(new ServerHandler());
                        }
                    });

            final ChannelFuture sync = serverBootstrap.bind(8888).sync();
            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            boosGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {

        MessageConsumer[] consumers = new MessageConsumer[4];
        for (int i = 0; i < consumers.length; i++) {

            MessageConsumer messageConsumer = new MessageConsumerImplServer(" server aaaa");
            consumers[i] = messageConsumer;
        }
        RingBufferWorkerPoolFactory.getInstance().initAndStart(ProducerType.MULTI, 1024 * 1024, new BlockingWaitStrategy(), consumers);
        new NettyServer();
    }
}