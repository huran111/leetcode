package netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.distruptor.MessageProducer;
import netty.distruptor.RingBufferWorkerPoolFactory;
import netty.entity.TranslatorData;

import java.util.UUID;

/**
 * @program: disruptor
 * @description:
 * @author: HuRan
 * @create: 2020-11-10 21:32
 */
public class ClientHandler extends SimpleChannelInboundHandler<TranslatorData> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TranslatorData msg) throws Exception {
//        try {
//            TranslatorData data = msg;
//            System.out.println("client receive server data: " + data.getId());
//            System.out.println("client receive server data: " + data.getName());
//            System.out.println("client receive server data: " + data.getMessage());
//            ctx.writeAndFlush(data);
//        } finally {
//            //SimpleChannelInboundHandler 继承该类不用下面的方法
//            // ReferenceCountUtil.release(msg);
//        }
        TranslatorData data = msg;
        String producerId = "c:" + UUID.randomUUID().toString();
        data.setId(producerId);
        final MessageProducer messageProducer = RingBufferWorkerPoolFactory.getInstance().getMessageProducer(producerId);
        messageProducer.sendData(data, ctx);

    }
}