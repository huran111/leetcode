package com.hr.注解优先于命名模式;

import java.lang.annotation.*;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-02-22 22:06
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionRepeatableCOntainer  {
    ExceptionRepeatableTest[] value();
}