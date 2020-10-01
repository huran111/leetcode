package java8.demo3;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

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

        final Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        final Optional<Dish> collect1 = menu.stream().collect(maxBy(dishComparator));
        System.out.println(collect1);

        final IntSummaryStatistics collect2 = menu.stream().collect(summarizingInt(Dish::getCalories));
        final double average = collect2.getAverage();
        System.out.println(average);
        //计算菜单得总热量
        final Integer collect3 = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println(collect3);
        //的reducing来找到热量最高的菜
        final Optional<Dish> collect4 = menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        System.out.println(collect4);
        final int sum = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(sum);

        final String collect5 = menu.stream().map(Dish::getName).collect(joining());
        System.out.println(collect5);
        final String s = menu.stream().map(Dish::getName).collect(reducing((s1, s2) -> s1 + s2)).get();
        //分组
        final Map<Dish.Type, List<Dish>> collect6 = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(collect6.toString());
        final Map<CaloricLevel, List<Dish>> collect7 = menu.stream().collect(groupingBy(dish -> {
            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
            else return CaloricLevel.FAT;
        }));
        System.out.println(collect7.toString());
    }

    public enum CaloricLevel {DIET, NORMAL, FAT}

    //查找第一个元素
    @Test
    public void test02() {
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
                System.out.print(anInt + "\t");
            }
            System.out.println();
        });
    }

    @Test
    public void testLong() {

        long start = System.currentTimeMillis();
        long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        double s = (System.currentTimeMillis() - start) / 1000;
        System.out.println(s);
        System.out.println(sum);
    }


}