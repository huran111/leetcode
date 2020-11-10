package netty.distruptor;

import com.lmax.disruptor.WorkHandler;
import netty.entity.TranslatorDataWapper;

/**
 * @program: disruptor
 * @description:
 * @author: HuRan
 * @create: 2020-11-10 21:51
 */
public abstract class MessageConsumer implements WorkHandler<TranslatorDataWapper> {
    private String consumerId;

    public MessageConsumer(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }
}