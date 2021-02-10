package com.hr;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: 用栈实现队列
 * @author: HuRan
 * @create: 2021-02-09 09:59
 */
public class _用栈实现队列 {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public _用栈实现队列() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    //入队
    public void push(int x) {
        inStack.push(x);
    }

    //出队
    public int pop() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    //获取队头元素
    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    //是否为空
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}