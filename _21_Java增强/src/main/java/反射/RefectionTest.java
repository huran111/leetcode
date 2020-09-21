package 反射;


import org.junit.Test;
import 注解.MaAnnation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;

/**
 * @program: java_suanfa
 * @description: 反射
 * @author: HuRan
 * @create: 2020-09-11 10:01
 */
public class RefectionTest {

    @Test
    public void person() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        final Class<Person> personClass = Person.class;
        final Constructor<Person> constructor = personClass.getConstructor(String.class, Integer.class);
        final Person huarn = constructor.newInstance("huarn", 23);
        System.out.println(huarn);
        //调用属性
        final Field age = personClass.getDeclaredField("age");
        age.set(huarn,10);
        System.out.println(huarn);
        //调用方法
        final Method show = personClass.getDeclaredMethod("show");
        show.invoke(huarn);
        final Constructor<Person> constructor1 = personClass.getDeclaredConstructor(Integer.class);
        constructor1.setAccessible(true);
        final Person person = constructor1.newInstance(23);
        System.out.println(person);
        final Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person,"huran");
        System.out.println(person);
    }
    @Test
    public void newClass() throws ClassNotFoundException {
        //方式一
        final Class<Person> personClass = Person.class;
        System.out.println(personClass);
        //方式二
        Person person=new Person();
        final Class<? extends Person> aClass = person.getClass();
        System.out.println(aClass);
        Person person2=new Person();
        final Class<? extends Person> aClass2 = person2.getClass();
        System.out.println(aClass2);
        //方式三
        final Class<?> aClass1 = Class.forName("反射.Person");
        System.out.println(aClass1);
        System.out.println(personClass == aClass);
        System.out.println(aClass == aClass1);
        System.out.println(aClass == aClass2);


        //方式四
        final ClassLoader classLoader = RefectionTest.class.getClassLoader();
        final Class<?> aClass3 = classLoader.loadClass("反射.Person");
        System.out.println(aClass ==aClass3);
    }
    @Test
    public void test3(){
        final Class<MaAnnation> maAnnationClass = MaAnnation.class;
        final Class<Comparator> comparatorClass = Comparator.class;
        final Class<Integer> integerClass = int.class;
        System.out.println(integerClass.getName());
        System.out.println(maAnnationClass.getName());
        final Class<Void> voidClass = void.class;
        int[] a=new int[1];
        int[]b=new int[2];
        final Class<? extends int[]> aClass = a.getClass();
        final Class<? extends int[]> aClass1 = b.getClass();
        System.out.println(aClass == aClass1);
    }
    @Test
    public void tt(){
        System.out.println(A.m);
    }
}

class A{

    static {
        m=100;
    }
    static int m=300;
}

