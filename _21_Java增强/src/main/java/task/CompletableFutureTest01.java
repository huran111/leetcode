package task;

import java.io.IOException;
import java.util.concurrent.*;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-16 21:17
 */
public class CompletableFutureTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        for (int i = 0; i < 10; i++) {
            CompletableFuture.supplyAsync(CompletableFutureTest01::code).thenAccept(CompletableFutureTest01::test);
        }
        System.in.read();
    }

    public static Future getPrice(String product) {
        CompletableFuture completableFuture = new CompletableFuture();
        new Thread(() -> {
            double price = doRpc(product);
            completableFuture.complete(price);
        }).start();
        System.out.println("==============");

        return completableFuture;
    }

    private static void test(Integer result) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " -测试 【" + result + "】完成，用时：" + 1);
    }

    public static Integer code() {
        int workingTime = ThreadLocalRandom.current().nextInt(3, 10);
        try {
            TimeUnit.SECONDS.sleep(workingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "完成工作，用时：" + workingTime);
        return workingTime;
    }

    private static double doRpc(String product) {
        System.out.println("第三方收到的产品:" + product);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 10.0;
    }
}