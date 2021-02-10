package 枚举;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description: 用EnumMap代替序数索引
 * @author: HuRan
 * @create: 2021-01-31 15:49
 */
public class Plant {
    public enum LifeCycle {
        ANNUAL, PERENNIAL, BIENNIAL

    }

    final String name;
    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifeCycle) {

        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }

    public void test() {

        int length = LifeCycle.values().length;
        Set<Plant>[] plantsByLiftCycle = (Set<Plant>[]) new Set[length];
        for (int i = 0; i < plantsByLiftCycle.length; i++) {
            plantsByLiftCycle[i] = new HashSet<>();
        }
        //
        Map<LifeCycle, Set<Plant>> p = new EnumMap<>(Plant.LifeCycle.class);
        for (LifeCycle value : LifeCycle.values()) {
            p.putIfAbsent(value, new HashSet<>());

        }
    }

    public static void main(String[] args) {

    }
}