package java8.demo3;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.WeakHashMap;

import static java.util.stream.Collectors.toList;

/**
 * @program: java_suanfa
 * @description:
 * @author: HuRan
 * @create: 2020-09-11 16:49
 */
public class Main {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT)
                , new Dish("beef", false, 700, Dish.Type.MEAT)
                , new Dish("chicken", false, 400, Dish.Type.MEAT)
                , new Dish("french fries", true, 530, Dish.Type.OTHER)
                , new Dish("rice", true, 350, Dish.Type.OTHER)
                , new Dish("season fruit", true, 120, Dish.Type.OTHER)
                , new Dish("pizza", true, 550, Dish.Type.OTHER)
                , new Dish("prawns", false, 300, Dish.Type.FISH)
                , new Dish("salmon", false, 450, Dish.Type.FISH));
        final List<String> collect = menu.stream().filter(d -> {
            System.out.println("filter:" + d.getCalories() + ":" + LocalDateTime.now().toString());
            return d.getCalories() > 300;
        }).map(d -> {
            System.out.println("mappping;" + d.getName() + ":" + LocalDateTime.now().toString());
            return d.getName();
        }).limit(3).collect(toList());
        System.out.println(collect);
    }

    //查找第一个元素
    @Test
    public void test02(){
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        final Optional<Integer> first = someNumbers.stream().map(x -> x * x).filter(x -> x % 3 == 0).findFirst();
        System.out.println(first.orElse(10).intValue());
    }
    @Test
    public void test() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        System.out.println("==============================================");
        List<int[]> pairs =
                numbers1.stream().flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i, j})).collect(toList());
        pairs.forEach(ints -> {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        });
    }
    @Test
    public void testLong(){

        long  start=System.currentTimeMillis();
        long sum=0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum+=i;
        }
       double s=( System.currentTimeMillis()-start)/1000;
        System.out.println(s);
        System.out.println(sum);
    }


}