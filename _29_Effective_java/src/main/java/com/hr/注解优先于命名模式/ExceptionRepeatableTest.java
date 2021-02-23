package com.hr.注解优先于命名模式;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionRepeatableCOntainer.class)
public @interface ExceptionRepeatableTest {
    Class<? extends Exception> value();
}
