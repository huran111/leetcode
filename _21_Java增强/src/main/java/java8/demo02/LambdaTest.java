package java8.demo02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.IntPredicate;
import java.util.function.IntToLongFunction;

/**
 * @program: java8-api
 * @description:
 * @author: HuRan
 * @create: 2020-09-09 10:18
 */
public class LambdaTest {
    public static void main(String[] args) throws IOException {
        execute(() -> {
        });
        //处理1行
       // processFile((BufferedReader br) -> br.readLine());
        //处理2 行
     //  processFile((BufferedReader br) -> br.readLine() + br.readLine());
        forEach(Arrays.asList(1, 2, 3, 4, 5), (Integer i) -> System.out.println(i));
        //避免装箱
        System.out.println("==========================");
        IntPredicate evenNumbers=(int i)->i%2==0;
        System.out.println(evenNumbers.test(10));
        IntPredicate negate = evenNumbers.negate();
        System.out.println(negate.test(10));
        IntToLongFunction longFunction=(int i)->i;
        long l = longFunction.applyAsLong(23);
    }


    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }

        return result;
    }

    @FunctionalInterface
    public interface Function<T, R> {
        R apply(T t);
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

    public interface Consumer<T> {
        void accept(T t);
    }

    public static String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(new File("")))) {
            return br.readLine();
        }
    }

    public static String processFile(BufferReadProcess p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }

    @FunctionalInterface
    public interface BufferReadProcess {
        String process(BufferedReader reader) throws IOException;
    }

    //事实上，fetch方法的返回类型是Callable<String>。 Callable<String>基本上就定义了一个方法，签名是() -> String，其中T被String代替 了。因为Lambda() -> "Trickyexample;-)"的签名是() -> String，所以在这个上下文 中可以使用Lambda
    public Callable<String> fetch() {
        return () -> "aaa";
    }

    //是因为Lambda() -> {}具有签名() -> void，这和Runnable中的 抽象方法run的签名相匹配。请注意，此代码运行后什么都不会做，因为Lambda是空的
    public static void execute(Runnable r) {
        r.run();
    }
}