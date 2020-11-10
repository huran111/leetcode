package netty.distruptor;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.ProducerType;
import netty.entity.TranslatorData;
import netty.entity.TranslatorDataWapper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

/**
 * @program: disruptor
 * @description:
 * @author: HuRan
 * @create: 2020-11-10 21:50
 */
public class RingBufferWorkerPoolFactory {
    private static class SingletonHolder {
        static final RingBufferWorkerPoolFactory instance = new RingBufferWorkerPoolFactory();
    }

    private RingBufferWorkerPoolFactory() {

    }

    public static RingBufferWorkerPoolFactory getInstance() {
        return SingletonHolder.instance;
    }

    public static Map<String, MessageProducer> producers = new ConcurrentHashMap<>();
    public static Map<String, MessageConsumer> consumers = new ConcurrentHashMap<>();
    private RingBuffer<TranslatorDataWapper> ringBuffer;
    private WorkerPool<?> workerPool;
    private SequenceBarrier sequenceBarrier;

    public void initAndStart(ProducerType type, int bufferSize, WaitStrategy waitStrategy, MessageConsumer[] messageConsumers) {
        this.ringBuffer = RingBuffer.create(type
                , new EventFactory<TranslatorDataWapper>() {
                    @Override
                    public TranslatorDataWapper newInstance() {
                        return new TranslatorDataWapper();
                    }
                }, bufferSize, waitStrategy);
        //设置序号阑珊
        this.sequenceBarrier = this.ringBuffer.newBarrier();
        this.workerPool = new WorkerPool<TranslatorDataWapper>(this.ringBuffer
                , this.sequenceBarrier, new EventExceptionHandler(), messageConsumers);
        for (MessageConsumer messageConsumer : messageConsumers) {
            consumers.put(messageConsumer.getConsumerId(), messageConsumer);
        }
        this.ringBuffer.addGatingSequences(this.workerPool.getWorkerSequences());
        this.workerPool.start(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2));

    }

    public MessageProducer getMessageProducer(String producerId) {
        MessageProducer messageProducer = producers.get(producerId);
        ;
        if (null == messageProducer) {
            messageProducer = new MessageProducer(this.ringBuffer, producerId);
            producers.put(producerId, messageProducer);
        }
        return messageProducer;
    }

    static class EventExceptionHandler implements ExceptionHandler<TranslatorDataWapper> {
        @Override
        public void handleEventException(Throwable ex, long sequence, TranslatorDataWapper event) {

        }

        @Override
        public void handleOnStartException(Throwable ex) {

        }

        @Override
        public void handleOnShutdownException(Throwable ex) {

        }
    }

}