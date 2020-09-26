package singleton;

/**
 * @program: leetcode
 * @description: 双重check
 * @author: HuRan
 * @create: 2020-09-25 22:25
 */
public class LazyDoubleSingleton {
    private static volatile LazyDoubleSingleton lazy = null;

    public synchronized static LazyDoubleSingleton getInstance() {
        if (lazy == null) {
            synchronized (LazyDoubleSingleton.class) {
                if (lazy == null) {
                    //  可能会发生指令重排序
                    lazy = new LazyDoubleSingleton();
                }
            }
        }
        return lazy;
    }
}