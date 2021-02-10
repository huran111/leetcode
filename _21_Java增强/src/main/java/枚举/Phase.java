package 枚举;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-01-31 16:09
 */
public enum Phase {
    SOLID, LIQUID, CAS;

    public enum Transition {
        MEIT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, CAS);
        public final Phase from;
        public final Phase to;

        Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

    }
}