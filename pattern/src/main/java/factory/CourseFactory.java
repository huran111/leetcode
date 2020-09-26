package factory;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-24 18:54
 */
public class CourseFactory {
//    public ICourse create(String name) {
//        if ("java".equalsIgnoreCase(name)) {
//            return new JavaCourse();
//        } else {
//            return null;
//        }
//    }
//    public  ICourse course(String className){
//        if(null!=className || !"".equalsIgnoreCase(className)){
//            try {
//                return (ICourse) Class.forName(className).newInstance();
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
//        return  null;
//    }
    public ICourse create(Class clazz){
        if(null==clazz){
            return  null;
        }
        try {
            return (ICourse) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  null;
    }
}