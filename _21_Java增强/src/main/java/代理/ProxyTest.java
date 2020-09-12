package 代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-12 22:19
 */
interface Human {
    String getHuran();

    void eat(String food);
}

class SuperMan implements Human {

    @Override
    public String getHuran() {
        return "我是胡冉";
    }

    @Override
    public void eat(String food) {
        System.out.println("炸鸡");
    }
}

class ProxyFactory {
    //返回一个代理类
    public static Object getProxyInstance(Object obj) {
        final MyInvocationhandler myInvocationhandler = new MyInvocationhandler();
        myInvocationhandler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), myInvocationhandler);
    }
}

class MyInvocationhandler implements InvocationHandler {

    private Object obg;//需要使用被代理类的对象赋值

    public void bind(Object obg) {
        this.obg = obg;
    }

    /**
     * @param proxy  代理类的对象
     * @param method 代理类的方法
     * @param args   代理类的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final Object invoke = method.invoke(obg, args);
        return invoke;
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        final SuperMan superMan = new SuperMan();
        final Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxyInstance.getHuran());
        proxyInstance.eat("炸鸡");
    }
}