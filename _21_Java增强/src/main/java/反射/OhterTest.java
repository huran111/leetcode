package 反射;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * @program: java_suanfa
 * @description:
 * @author: HuRan
 * @create: 2020-09-11 14:55
 */
public class OhterTest {
    @Test
    public void test1(){
        //当前类构造器 public
        final Class<Person> personClass = Person.class;
        final Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        //当前类构造器 所有
        final Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }
    //运行时的父类
    @Test
    public void test2(){
        final Class<Person> personClass = Person.class;
        final Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);
    }

    //运行时的父类泛型
    @Test
    public void test3(){
        final Class<Person> personClass = Person.class;
        final Type genericSuperclass = personClass.getGenericSuperclass();
        System.out.println(genericSuperclass);

        ParameterizedType parameterizedType=(ParameterizedType)genericSuperclass;
        //获取泛型参数
        final Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type actualTypeArgument : actualTypeArguments) {
            System.out.println(actualTypeArgument);
        }
    }
    @Test
    public void  test03(){
        final Class<Person> personClass = Person.class;
        final Class<?>[] interfaces = personClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
        //获取运行时父类实现的接口
        final Class<?>[] interfaces1 = personClass.getSuperclass().getInterfaces();
        for (Class<?> aClass : interfaces1) {
            System.out.println(aClass);
        }
    }
    //获取运行时类所在的包
    @Test
    public void test4(){
        final Class<Person> personClass = Person.class;
        final Package aPackage = personClass.getPackage();
        System.out.println(aPackage.getName());
        final Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
    //获取指定的属性
    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        final Class<Person> personClass = Person.class;

        final Person person = personClass.newInstance();

        final Field name = personClass.getField("name");
        name.setAccessible(true);
        name.set(person,"aaa");
        System.out.println(person.toString());
        final Method show = personClass.getDeclaredMethod("show", String.class);
        final Object invoke = show.invoke(person, "1");
        System.out.println(invoke);
    }
    //如何运行时类中的构造器
    @Test
    public void test44() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        final Class<Person> personClass = Person.class;
        final Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        final Person person = declaredConstructor.newInstance("A");
        System.out.println(person);
    }
}