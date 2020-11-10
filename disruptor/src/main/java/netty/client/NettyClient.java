package netty.client;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.dsl.ProducerType;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import netty.common.MarashallingCodeCFactory;
import netty.distruptor.MessageConsumer;
import netty.distruptor.MessageConsumerImplClient;
import netty.distruptor.MessageConsumerImplServer;
import netty.distruptor.RingBufferWorkerPoolFactory;
import netty.entity.TranslatorData;
import netty.server.NettyServer;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: disruptor
 * @description:
 * @author: HuRan
 * @create: 2020-11-10 21:29
 */
public class NettyClient {
    public static final String HOST = "localhost";
    public static final int PORT = 8888;
    private Channel channel;
    private EventLoopGroup workGroup;
    private ChannelFuture cf;

    public NettyClient(String host, int port) {
        this.connect(host, port);
    }

    private void connect(String host, int port) {
        workGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            final Bootstrap group = bootstrap.group(workGroup);
            group.channel(NioSocketChannel.class)
                    .option(ChannelOption.RCVBUF_ALLOCATOR, AdaptiveRecvByteBufAllocator.DEFAULT)
                    .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                    .handler(new LoggingHandler(LogLevel.DEBUG))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(MarashallingCodeCFactory.buildMarshallingDecoder());
                            ch.pipeline().addLast(MarashallingCodeCFactory.buildMarshallingEncoder());
                            ch.pipeline().addLast(new ClientHandler());
                        }
                    });
            cf = bootstrap.connect(host, port).sync();
            this.channel = cf.channel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void sendData() {
        for (int i = 0; i < 10; i++) {
            System.out.println("==");
            TranslatorData data = new TranslatorData();
            data.setId("A:" + i);
            data.setName("Hr " + i);
            data.setMessage("hello " + i);
            this.channel.writeAndFlush(data);
        }
    }

    public void close() throws InterruptedException {
        cf.channel().closeFuture().sync();
        workGroup.shutdownGracefully();
    }

    public static void main(String[] args) {
        MessageConsumer[] consumers = new MessageConsumer[4];
        for (int i = 0; i < consumers.length; i++) {

            MessageConsumer messageConsumer = new MessageConsumerImplClient("client:aaa");
            consumers[i] = messageConsumer;
        }
        RingBufferWorkerPoolFactory.getInstance().initAndStart(ProducerType.MULTI, 1024 * 1024, new BlockingWaitStrategy(), consumers);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("---------  " + RingBufferWorkerPoolFactory.producers.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new NettyClient(HOST, PORT).sendData();


    }
}