package proxy.jdk;

import java.lang.reflect.Method;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-27 22:32
 */
public interface GPinvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}