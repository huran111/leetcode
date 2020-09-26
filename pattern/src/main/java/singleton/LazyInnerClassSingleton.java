package singleton;

/**
 * @program: leetcode
 * @description: 静态内部类
 * @author: HuRan
 * @create: 2020-09-25 22:43
 */
public class LazyInnerClassSingleton {
    private LazyInnerClassSingleton() {
        if(LazyHolder.lazy!=null){
            throw  new RuntimeException("no");
        }
    }
    //懒汉式 单例模式 利用了内部类的特性
    public static final LazyInnerClassSingleton getInstance() {
        return LazyHolder.lazy;
    }

    private static class LazyHolder {
        private static final LazyInnerClassSingleton lazy=new LazyInnerClassSingleton();
    }
}