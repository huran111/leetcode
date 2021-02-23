package com.hr.接口模拟可扩展的枚举;

import java.util.Collection;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-02-22 21:27
 */
public class Main {
    public static void main(String[] args) {
        double x = Double.parseDouble("2");
        double y = Double.parseDouble("23");
        test(ExtendOperator.class, x, y);
    }
    //class对象即表示枚举又表示Operation的子类
    private static <T extends Enum<T> & Operation> void test(Class<ExtendOperator> extendOperatorClass, double x, double y) {
        ExtendOperator[] enumConstants = extendOperatorClass.getEnumConstants();
        for (ExtendOperator enumConstant : enumConstants) {
            System.out.printf("%f %s %f=%f\n", x, enumConstant, y, enumConstant.apply(x, y));
        }
    }
    //有限通配符类型 而不是具体的对象
    private static void test(Collection<? extends Operation> opSet, double x, double y){
        for (Operation op : opSet) {
            System.out.printf("%f %s %f=%f\n", x, op, y, op.apply(x, y));
        }
    }
}