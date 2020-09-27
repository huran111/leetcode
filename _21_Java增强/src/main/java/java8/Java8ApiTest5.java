package java8;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @program: java8-api
 * @description: 构建流
 * @author: HuRan
 * @create: 2020-09-08 09:46
 */
public class Java8ApiTest5 {
    public static void main(String[] args) {
        final Stream<String> stringStream = Stream.of("java 8", "c", "python", "action");
        stringStream.map(String::toUpperCase).forEach(System.out::println);
        final Stream<Object> empty = Stream.empty();
        int[] numbers = {2, 3, 5, 7, 11, 13};
        final int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);
        try (final Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset());
        ) {
            final long count = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //无限流
        Stream.iterate(0,   n->n+2).limit(10).forEach(System.out::println);
    }
}