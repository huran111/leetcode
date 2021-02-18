package com.hr.逃逸分析;

/**
 * @program: leetcode
 * @description: 逃逸分析案例
 * @author: HuRan
 * @create: 2021-02-18 19:33
 */
public class EscapeAnalysis {
    private EscapeAnalysis obj;

    public EscapeAnalysis getInstance() {
        return obj == null ? new EscapeAnalysis() : obj;
    }
    //成员属性赋值，发生逃逸
    public void setObj(){
        this.obj=new EscapeAnalysis();
    }
    //可以进行逃逸分析
    public void useEscapeAnalysis(){
        EscapeAnalysis analysis=new EscapeAnalysis();
    }
    //发生逃逸
    public void useEscapeAnalysis2(){
        EscapeAnalysis instance = getInstance();

    }
    public static void main(String[] args) {

    }
}