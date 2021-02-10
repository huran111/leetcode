package com.hr;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-01-30 11:22
 */
public class _有效括号 {
    public static void main(String[] args) {


    }

    public boolean isVaild2(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                //如果是左字符
                stack.push(c);
            } else {
                //右括号
                //如果栈是空的说明无效
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char left = stack.pop();
                    if (left == '(' && c != ')') {
                        return false;
                    }
                    if (left == '[' && c != ']') {
                        return false;
                    }
                    if (left == '{' && c != '}') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty(); //最后栈是空的 说明是有效的
    }

    public boolean isVaild(String s) {
        while (s.contains("{}") ||
                s.contains("[]") ||
                s.contains("()")) {
            s = s.replace("{}", "");
            s = s.replace("[]", "");
            s = s.replace("()", "");

        }
        return s.isEmpty();
    }
}