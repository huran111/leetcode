package factory2;

import factory.ICourse;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-24 21:44
 */
public abstract interface ICourseFactory {

    abstract ICourse create();
}