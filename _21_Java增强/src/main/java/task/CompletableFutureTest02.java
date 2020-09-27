package task;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-16 21:17
 */
public class CompletableFutureTest02 {
    public static void main(String[] args) {
        Map<Integer,String> works= new HashMap<>();
        works.put(0, "a");
        works.put(1, "b");
        works.put(2, "c");
        works.put(3, "d");
        works.put(4, "e");
        works.put(5, "f");
        Map<Integer, String> resultMapv = new HashMap<>(6);

        System.out.println("Strat." + new Date().toLocaleString());
        final CompletableFuture[] completableFutures = works.entrySet().stream().map(integerStringEntry -> CompletableFuture
                .supplyAsync(() -> process(integerStringEntry))
                .whenComplete((result, e) -> {
                    resultMapv.put(result.getKey(), result.getValue());
                })).toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(completableFutures).join();
        System.out.println("End."+new Date().toLocaleString());
        System.out.println(resultMapv);
    }
    private static Map.Entry<Integer, String> process(Map.Entry<Integer, String> entry) {
        System.out.println(Thread.currentThread().getName());
        int workingTime = ThreadLocalRandom.current().nextInt(1, 10);
        try {
            TimeUnit.SECONDS.sleep(workingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "完成工作，用时：" + workingTime);
        entry.setValue(entry.getValue() + "_finished");
        return entry;
    }
}