package singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @program: leetcode
 * @description: 测试类
 * @author: HuRan
 * @create: 2020-09-25 22:47
 */
public class LazyTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final Class<LazyInnerClassSingleton> aClass = LazyInnerClassSingleton.class;
        final Constructor<LazyInnerClassSingleton> constructor = aClass.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        final LazyInnerClassSingleton var1 = constructor.newInstance();
        final LazyInnerClassSingleton var2 = LazyInnerClassSingleton.getInstance();

        System.out.println(var1 == var2);


    }
}