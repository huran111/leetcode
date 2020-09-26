package demo01;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-26 12:42
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) {
        final ArrayBlockingQueue queue = new ArrayBlockingQueue(100000000);
        final long startTime = System.currentTimeMillis();
        new Thread(new Runnable() {
            public void run() {
                long i = 0;
                while (i < Constant.EVENT_NUM_OHM) {
                    Data data = new Data(i, "a");
                    try {
                        queue.put(data);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                int k=0;
                while (k<Constant.EVENT_NUM_OHM){
                    try {
                        queue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    k++;
                }
                long endTime=System.currentTimeMillis();
                System.out.println(endTime - startTime);
            }

        }).start();

    }
}