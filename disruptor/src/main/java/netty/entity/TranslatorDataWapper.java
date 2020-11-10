package netty.entity;

import io.netty.channel.ChannelHandlerContext;

import java.nio.channels.Channel;

/**
 * @program: disruptor
 * @description:
 * @author: HuRan
 * @create: 2020-11-10 21:56
 */
public class TranslatorDataWapper {
    private TranslatorData data;
    private ChannelHandlerContext ctx;

    public TranslatorData getData() {
        return data;
    }

    public void setData(TranslatorData data) {
        this.data = data;
    }

    public ChannelHandlerContext getCtx() {
        return ctx;
    }

    public void setCtx(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }
}