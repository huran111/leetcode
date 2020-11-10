package netty.server;

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
 * @create: 2020-11-10 20:51
 */
public class ServerHandler extends SimpleChannelInboundHandler<TranslatorData> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TranslatorData msg) throws Exception {
//        TranslatorData translatorData = msg;
//        System.out.println(translatorData.getId());
//        System.out.println(translatorData.getName());
//        System.out.println(translatorData.getMessage());
//        TranslatorData data = new TranslatorData();
//        data.setId("resp: " + translatorData.getId());
//        data.setName("resp: " + translatorData.getName());
//        data.setMessage("resp: " + translatorData.getMessage());
//        if (ctx.channel().isActive()) {
//            ctx.writeAndFlush(translatorData);
//        }
        TranslatorData translatorData = msg;
        String producerId = "p:" + UUID.randomUUID().toString();
        translatorData.setId(producerId);
        final MessageProducer messageProducer = RingBufferWorkerPoolFactory.getInstance().getMessageProducer(producerId);
        messageProducer.sendData(translatorData, ctx);

    }
}