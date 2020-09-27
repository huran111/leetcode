package abstractfactory;

import factory.ICourse;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-24 22:05
 */
public interface ICourseFactory {
    ICourse createCourse();

    INote createNote();

    IVideo createVideo();
}