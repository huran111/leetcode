package demo01;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import java.util.concurrent.Executors;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-26 12:49
 */
public class DisruptorTest {
    public static void main(String[] args) {
        int ringBufferSize = 65536;
        final Disruptor<Data> dataDisruptor = new Disruptor<Data>(new EventFactory<Data>() {
            @Override
            public Data newInstance() {
                return new Data();
            }
        }, ringBufferSize, Executors.newSingleThreadExecutor()
                , ProducerType.SINGLE, new YieldingWaitStrategy());
        DataConsumer dataConsumer = new DataConsumer();
        dataDisruptor.handleEventsWith(dataConsumer);
        dataDisruptor.start();
        new Thread(new Runnable() {
            public void run() {
                RingBuffer<Data> ringBuffer = dataDisruptor.getRingBuffer();
                for (long i = 0; i < Constant.EVENT_NUM_OHM; i++) {
                    long seq = ringBuffer.next();
                    Data data = ringBuffer.get(seq);
                    data.setId(i);
                    data.setName("B");
                    ringBuffer.publish(seq);

                }
            }
        }).start();
    }

}