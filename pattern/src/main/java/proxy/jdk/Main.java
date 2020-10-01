package proxy.jdk;

import proxy.staticproxy.Person;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-27 22:21
 */
public class Main {
    public static void main(String[] args) throws IOException {
        final Person instance = (Person) new Meipo().getInstance(new Girl());
        instance.findLove();
        final byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
        final FileOutputStream fileOutputStream = new FileOutputStream("E://$Proxy0.class");
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }
}