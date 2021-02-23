package Reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

/**
 * @program: LeetCode
 * @description: 用于在JVM平台上基于响应式流规范构建非阻塞异步应用
 * @author: HuRan
 * @create: 2021-02-21 15:08
 */
public class Test01 {
    /**
     * just()：可以指定序列中包含的全部元素。创建出来的 Flux 序列在发布这些元素之后会自动结束。
     * fromArray()，fromIterable()和 fromStream()：可以从一个数组、Iterable 对象或 Stream 对象中创建 Flux 对象。
     * empty()：创建一个不包含任何元素，只发布结束消息的序列。
     * error(Throwable error)：创建一个只包含错误消息的序列。
     * never()：创建一个不包含任何消息通知的序列。
     * range(int start, int count)：创建包含从 start 起始的 count 个数量的 Integer 对象的序列。
     * interval(Duration period)和 interval(Duration delay, Duration period)：创建一个包含了从 0 开始递增的 Long 对象的序列。其中包含的元素按照指定的间隔来发布。除了间隔时间之外，还可以指定起始元素发布之前的延迟时间。
     * intervalMillis(long period)和 intervalMillis(long delay, long period)：与 interval()方法的作用相同，只不过该方法通过毫秒数来指定时间间隔和延迟时间。
     */
    @Test
    public void jest() {
        Flux.just("Hello,Wolrd").subscribe(System.out::println);
    }

    @Test
    public void fromArray() {
        Flux.fromArray(new Integer[]{1, 2, 3}).subscribe(System.out::println);
    }

    @Test
    public void empty() {
        Flux.empty().subscribe(System.out::println);
    }

    @Test
    public void range() {
        Flux.range(1, 10).subscribe((s) -> {
            System.out.println(s);
            System.out.println(Thread.currentThread().getName());
        });
    }

    @Test
    public void interval() {
        Flux.interval(Duration.of(10, ChronoUnit.SECONDS)).subscribe(System.out::println);
    }

    @Test
    public void generate() {
        Flux.generate(sink -> {
            sink.next("helllo");
            sink.complete();
        }).subscribe(System.out::println);
        final Random random = new Random();
        Flux.generate(ArrayList::new, (list, sink) -> {
            int value = random.nextInt(100);
            list.add(value);
            sink.next(value);
            if (list.size() == 10) {
                sink.complete();
            }
            return list;
        }).subscribe(System.out::println);
    }

    @Test
    public void create() {
        Flux.create(sink -> {
            for (int i = 0; i < 10; i++) {
                sink.next(i);
            }
            sink.complete();
        }).subscribe(System.out::println);
    }
    //==========================       创建 Mono

    /**
     * Mono 的创建方式与之前介绍的 Flux 比较相似。Mono 类中也包含了一些与 Flux 类中相同的静态方法。这些方法包括 just()，empty()，error()和 never()等。除了这些方法之外，Mono 还有一些独有的静态方法。
     * fromCallable()、fromCompletionStage()、fromFuture()、fromRunnable()和 fromSupplier()：分别从 Callable、CompletionStage、CompletableFuture、Runnable 和 Supplier 中创建 Mono。
     * delay(Duration duration)和 delayMillis(long duration)：创建一个 Mono 序列，在指定的延迟时间之后，产生数字 0 作为唯一值。
     * ignoreElements(Publisher source)：创建一个 Mono 序列，忽略作为源的 Publisher 中的所有元素，只产生结束消息。
     * justOrEmpty(Optional<? extends T> data)和 justOrEmpty(T data)：从一个 Optional 对象或可能为 null 的对象中创建 Mono。只有 Optional 对象中包含值或对象不为 null 时，Mono 序列才产生对应的元素。
     */
    @Test
    public void fromSupplier() {
        Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);
    }

    @Test
    public void justOrEmpty() {
        Mono.justOrEmpty(Optional.of("Hello")).subscribe(System.out::println);
    }

    @Test
    public void MonoCreate() {
        Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);
    }

    @Test
    public void buffer() {
        //5个包含了20个元素的数组
        Flux.range(1, 100).buffer(20).subscribe(System.out::println);
        System.out.println("============================================================================================================================================");
        // 2 个包含了 10 个元素的数组
        Flux.interval(Duration.ofMillis(100)).buffer(Duration.ofMillis(100)).take(2).toStream().forEach(System.out::println);
        System.out.println("============================================================================================================================================");
        //表示每个集合中的元素所要满足的条件的 Predicate 对象
        Flux.range(1, 10).bufferUntil(i -> i % 3 == 0).subscribe(System.out::println);
        System.out.println("============================================================================================================================================");
        Flux.range(1, 10).bufferWhile(i -> i % 2 == 0).subscribe(System.out::println);
        System.out.println("============================================================================================================================================");
        Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);
    }

    @Test
    public void window(){
        Flux.range(1, 100).window(10).subscribe(System.out::println);
        System.out.println("============================================================================================================================================");
        Flux.interval(Duration.ofMillis(100)).window(Duration.ofMillis(1001)).take(2).toStream().forEach(System.out::println);
    }
    @Test
    public void zipWith(){
        Flux.just("a", "b")
                .zipWith(Flux.just("c", "d"))
                .subscribe(System.out::println);
        Flux.just("a", "b")
                .zipWith(Flux.just("c", "d"), (s1, s2) -> String.format("%s-%s", s1, s2))
                .subscribe(System.out::println);
    }
}