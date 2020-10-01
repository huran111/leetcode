package proxy.dbroute.db;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-27 22:12
 */
public class DynamicDataSourceEntity {
    private final static ThreadLocal<String> local = new ThreadLocal<>();

    private DynamicDataSourceEntity() {
    }

    public static String get() {
        return local.get();
    }

    public static void set(String source) {
        local.set(source);
    }

    public static void set(int year) {
        local.set("DB_" + year);
    }

    public static void reset() {
        local.set(null);
    }
}