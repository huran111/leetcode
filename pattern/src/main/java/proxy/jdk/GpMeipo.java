package proxy.jdk;

import proxy.staticproxy.Person;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-27 22:34
 */
public class GpMeipo implements GPinvocationHandler {
    private Person target;

    public Object getInstance(Person person) {
        this.target = person;
        final Class<? extends Person> aClass = target.getClass();
        return null;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass());
        before();
        final Object invoke = method.invoke(this.target, args);
        after();
        return invoke;
    }

    public void before() {
        System.out.println("我是媒婆");

    }

    public void after() {
        System.out.println("找到了");
    }
}