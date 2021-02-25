package com.hr.设置虚拟机运行方式;

/**
 * @program: leetcode
 * @description: 解释执行和JIT执行
 * -Xint   3925ms  解释器  一行一行 执行
 * -XComp   21079ms  编译器  编译执行
 * -Xmixed  2198 ms  混编
 * @author: HuRan
 * @create: 2021-02-25 20:20
 */
public class IntCompTest {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        test(1000000);

        System.out.println(System.currentTimeMillis()-start);
    }

    private static void test(int count) {
        for (int i = 0; i < count; i++) {
            label:for(int j=2;j<100;j++){
                for(int k=2;k<=Math.sqrt(j);k++){
                    if(j % k == 0){
                        continue  label;
                    }
                }
            }
        }
    }
}