package netty.distruptor;

import io.netty.channel.ChannelHandlerContext;
import netty.entity.TranslatorData;
import netty.entity.TranslatorDataWapper;

/**
 * @program: disruptor
 * @description:
 * @author: HuRan
 * @create: 2020-11-10 22:15
 */
public class MessageConsumerImplServer extends MessageConsumer {
    public MessageConsumerImplServer(String consumerId) {
        super(consumerId);
    }

    @Override
    public void onEvent(TranslatorDataWapper event) throws Exception {
        final TranslatorData data = event.getData();
        final ChannelHandlerContext ctx = event.getCtx();
        System.out.println("收到Server端信息: " + data.getId() + "  " + data.getName() + " " + data.getMessage());
        TranslatorData resp = new TranslatorData();
        resp.setId("resp :" + resp.getId());
        resp.setMessage("resp:" + resp.getMessage());
        resp.setName("resp:" + resp.getName());
        ctx.writeAndFlush(resp);
    }
}