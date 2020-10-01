package java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: java8-api
 * @description:
 * @author: HuRan
 * @create: 2020-09-08 09:46
 */
public class Java8ApiTest {
    @Test
    public void identity() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        Map<String, Integer> collect = stream.collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(collect);
    }

    @Test
    public void apply() {
        Function<Integer, Integer> test = i -> i + 1;
        Function<Integer, Integer> test2 = i -> i - 1;
        System.out.println(calcute(test, 6));
        System.out.println(calcute(test2, 6));
    }

    //返回一个组合函数，首先将before函数应用于其输入，然后将此函数应用于结果。 如果任一函数的评估引发异常，则将其转发给组合函数的调用者。
    //f(g(x))
    @Test
    public void compose() {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> compose = f.compose(g);
        System.out.println(compose.apply(1));
    }

    @Test
    public void andThen() {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> compose = f.andThen(g);
        System.out.println(compose.apply(1));
    }

    @Test
    public void consumer() {
        Consumer<Integer> consumer = x -> {
            int a = x + 2;
            System.out.println(a);
        };
        Consumer<Integer> consumer2 = x -> {
            int a = x + 2;
            System.out.println(a);
        };
        Consumer<Integer> consumer1 = consumer.andThen(consumer2);
        consumer1.accept(10);
        consumer1.accept(12);
    }

    @Test
    public void supplier() {
        Supplier<String> supplier = String::new;
        System.out.println(supplier.get());
    }

    @Test
    public void unaryOperator() {
        UnaryOperator<Integer> dda = x -> x + 1;
        System.out.println(dda.apply(1));
    }

    @Test
    public void biComsumer() {
        BiConsumer<Integer, Integer> biConsumer = new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer integer, Integer integer2) {
                System.out.println(integer * integer2);
            }

        };
        biConsumer.accept(10, 10)
        ;
    }

    @Test
    public void binaryOperator() {
        BinaryOperator<Integer> binaryOperator = (x, y) -> {
            int a = x * 2;
            int b = y + 2;
            return a + b;
        };
        Integer apply = binaryOperator.apply(1, 2);
        System.out.println(apply);
    }

    @Test
    public void methodTest() {
        // 类：：静态方法名
        Comparator<Integer> cam1 = (x, y) -> x.compareTo(y);
        int compare = cam1.compare(3, 4);
        System.out.println(compare);
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        System.out.println(bp.test("a", "b"));
        BiPredicate<String, String> bp1= String::equals;
        System.out.println(bp1.test("a", "b"));
    }
    @Test
    public  void stream(){
        String[] dd = { "a", "b", "c" };
        Arrays.stream(dd).forEach(System.out::print);// abc
        Stream.of(dd).forEach(System.out::println);
        Stream.iterate(0, x->x+1).limit(10).forEach(System.out::println);
        Stream.generate(()->"x").limit(10).forEach(System.out::println);
        List<Integer> numbers = Stream.iterate(1, x -> x + 1).limit(10).collect(Collectors.toList());
        System.out.println(numbers);
        Integer dddd = numbers.stream().reduce(0, (a, b) -> a + b, (a, b) -> a - b);
        System.out.println(dddd);
    }
    @Test
    public  void map(){
        String[] dd = { "a", "b", "c" };
        Arrays.stream(dd).forEach(System.out::print);// abc
        Stream.of(dd).forEach(System.out::println);
        Stream.iterate(0, x->x+1).limit(10).forEach(System.out::println);
        Stream.generate(()->"x").limit(10).forEach(System.out::println);
        List<Integer> numbers = Stream.iterate(1, x -> x + 1).limit(10).collect(Collectors.toList());
        System.out.println(numbers);
        Integer dddd = numbers.stream().reduce(0, (a, b) -> a + b, (a, b) -> a - b);
        System.out.println(dddd);
    }
    /**
     * 计算
     *
     * @param test   计算公式
     * @param number 值
     * @return 结果
     */
    public static Integer calcute(Function<Integer, Integer> test, Integer number) {
        return test.apply(number);
    }
}