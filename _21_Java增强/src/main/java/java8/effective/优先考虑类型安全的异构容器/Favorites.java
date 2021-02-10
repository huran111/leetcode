package java8.effective.优先考虑类型安全的异构容器;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-01-24 12:06
 */
public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        // favorites.putIfAbsent(Objects.requireNonNull(type), instance);
        //检验instance是否真的是type所表示的类型的实例，只需要一个动态的转换，就可以拥有运行时的类型安全
        favorites.putIfAbsent(Objects.requireNonNull(type), type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 2323);
        f.putFavorite(Class.class, Favorites.class);
        String string = f.getFavorite(String.class);

        Integer integer = f.getFavorite(Integer.class);
        Class aClass = f.getFavorite(Class.class);
        System.out.printf(" %s %x %s%n", string, integer, aClass.getName());
    }

    static Annotation getAnnotation(AnnotatedElement element, String annotaionTypeName) {
        Class<?> annotationType = null;
        try {
            annotationType = Class.forName(annotaionTypeName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return element.getAnnotation(annotationType.asSubclass(Annotation.class));

    }
}