package java8.demo01;

import org.junit.Test;
import 静态变量.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @program: java8-api
 * @description:
 * @author: HuRan
 * @create: 2020-09-08 18:14
 */
public class FilterApples {

    @Test
    public void appleTest(){
        List<Apple> list=new ArrayList<>();
        list.add(new Apple("h",8));
        list.add(new Apple("a",67));
        list.add(new Apple("k",23));
        list.add(new Apple("s",2));
        list.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getName));
        System.out.println(list.toString());


    }
    //函数复合
    @Test
    public void  test(){
        Function<Integer,Integer> f=x->x+1;
        Function<Integer ,Integer>ff=x->x*2;
        final Function<Integer, Integer> function = f.andThen(ff);
        System.out.println(function.apply(1));
        final Function<Integer, Integer> compose = f.compose(ff);
        System.out.println(compose.apply(1));
    }



    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple(), new Apple());
        fileApps(list, new AppleHeavyPredicate());
        fileApps(list, new AppleColorPredicate());
        fileApps(list, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getName());
            }
        });
        process(() -> System.out.println("sdfsdfs"));
    }

    public static void process(Runnable r) {
        r.run();
    }

    public static List<Apple> fileApps(List<Apple> apples, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    public interface Predicate<T> {
        boolean test(T t);
    }

    @Test
    public void test03() {
        Supplier<Apple> c1 = Apple::new;
        final Apple apple = c1.get();
        System.out.println(apple.toString());
    }

    //    public Apple(String name){}
    @Test
    public void test04() {
        Function<String, Apple> c2 = Apple::new;
        // Function<String, Apple> c22 = name -> new Apple(name);
        final Apple apple = c2.apply("胡冉");
        System.out.println(apple.getName());
    }

    @Test
    public void test05() {
        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = map(weights, Apple::new);
        System.out.println(apples.toString());
    }
    @Test
    public void test6(){
        BiFunction<String, Integer, Apple> c3= Apple::new;
        final Apple green = c3.apply("green", 10);
        System.out.println(green.toString());
    }
    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {

        List<Apple> apples = new ArrayList<>(
        );
        for (Integer integer : list) {
            apples.add(f.apply(integer));
        }
        return apples;
    }

}