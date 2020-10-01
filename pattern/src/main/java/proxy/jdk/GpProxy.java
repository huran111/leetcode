package proxy.jdk;

import java.lang.reflect.InvocationHandler;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-27 22:33
 */
public class GpProxy {
    public static Object newProxyInstance(GpClassLoader loader,
                                          Class<?>[] interfaces,
                                          GPinvocationHandler h) {
        return null;
    }
}