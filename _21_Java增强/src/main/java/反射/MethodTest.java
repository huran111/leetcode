package 反射;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @program: java_suanfa
 * @description: 方法测试
 * @author: HuRan
 * @create: 2020-09-11 14:35
 */
public class MethodTest {
    @Test
    public void test() {
        //获取当前类及其所有父类public的方法
        final Class<Person> personClass = Person.class;
        final Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        //获取当前类所有方法包括private的方法
        System.out.println("-------------------");
        final Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }

    @Test
    public void test1() {
        final Class<Person> personClass = Person.class;
        final Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            final Annotation[] annotations = declaredMethod.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
            //权限修饰符
            final String s = Modifier.toString(declaredMethod.getModifiers());
            System.out.print(s + "\t");
            System.out.print(declaredMethod.getReturnType().getName() + "\t");
            System.out.print("(");
            final Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1) {
                        System.out.println(parameterTypes[i].getName() + " args_" + i);
                        break;
                    }
                    System.out.println(parameterTypes[i].getName() + "args_" + i + ",");
                }
            }
            System.out.print(")");
            //方法异常
            final Class<?>[] exceptionTypes = declaredMethod.getExceptionTypes();
            if(!(exceptionTypes==null&&exceptionTypes.length==0)){
                for (int i = 0; i < exceptionTypes.length; i++) {
                    System.out.println(exceptionTypes[i].getName());
                }
            }
            System.out.println();
        }
    }
}