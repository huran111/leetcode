package 反射;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @program: java_suanfa
 * @description:
 * @author: HuRan
 * @create: 2020-09-11 12:20
 */
public class ClassLoaderTest {
    public static void main(String[] args) {

        final ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        final ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        final ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
        final ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);
        // 此时三个ClassLoader是同一个对象
        System.out.println(Thread.currentThread().getContextClassLoader()); // 当前线程的类加载器
        System.out.println(ClassLoaderTest.class.getClassLoader()); // 当前类的类加载器
        System.out.println(ClassLoader.getSystemClassLoader()); // 系统初始的类加载器
    }
    @Test
    public void newInstance() throws IllegalAccessException, InstantiationException {
        final Class<Person> personClass = Person.class;
        final Person person = personClass.newInstance();
        System.out.println(person.toString());
    }

    @Test
    public void person(){
        final Class<Person> personClass = Person.class;
        //获取当前类及其父类中声明为public的属性
        final Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("===========");
        //获取到当前运行时类自己的属性  不考虑权限
        final Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("===========");
    }
    @Test
    public void person2(){
        final Class<Person> personClass = Person.class;
        final Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //权限修饰符
            final int modifiers = declaredField.getModifiers();
            System.out.print(modifiers+"\t");
            //数据类型
            final Class<?> type = declaredField.getType();
            System.out.print(type.getName()+"\t");
            //变量名称
            System.out.println(declaredField.getName());
        }
    }
}