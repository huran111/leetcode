package 注解;

import java.lang.annotation.*;

@Inherited
@Repeatable(MaAnnations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.CONSTRUCTOR,ElementType.LOCAL_VARIABLE,ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})
public @interface MaAnnation
{
    String  value() default "hello";
}
