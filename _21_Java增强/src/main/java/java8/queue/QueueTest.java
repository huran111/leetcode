package java8.queue;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @program: java_suanfa
 * @description:
 * @author: HuRan
 * @create: 2020-09-16 17:26
 */
public class QueueTest {
    public static void main(String[] args) {
        ConcurrentLinkedDeque deque=new ConcurrentLinkedDeque();
        for (int i = 0; i < 150000; i++) {
            deque.add(new Byte[1024]);
           // deque.pollLast();
        }
    }
}