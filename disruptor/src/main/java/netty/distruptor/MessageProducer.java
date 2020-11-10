package netty.distruptor;

import com.lmax.disruptor.RingBuffer;
import io.netty.channel.ChannelHandlerContext;
import netty.entity.TranslatorData;
import netty.entity.TranslatorDataWapper;

/**
 * @program: disruptor
 * @description:
 * @author: HuRan
 * @create: 2020-11-10 21:51
 */
public class MessageProducer {
    private RingBuffer<TranslatorDataWapper> ringBuffer;
    private String producerId;

    public MessageProducer(RingBuffer<TranslatorDataWapper> ringBuffer, String producerId) {
        this.ringBuffer = ringBuffer;
        this.producerId = producerId;
    }

    public void sendData(TranslatorData data, ChannelHandlerContext ctx) {
        final long next = ringBuffer.next();
        try {
            final TranslatorDataWapper wapper = ringBuffer.get(next);
            wapper.setData(data);
            wapper.setCtx(ctx);

        } finally {
            this.ringBuffer.publish(next);
        }


    }
}