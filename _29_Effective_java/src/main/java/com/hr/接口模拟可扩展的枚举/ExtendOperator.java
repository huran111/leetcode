package com.hr.接口模拟可扩展的枚举;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-02-22 21:25
 */
public enum ExtendOperator implements Operation {
    EXP("^") {
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        @Override
        public double apply(double x, double y) {
            return x % y;
        }
    };
    private final String symbol;

    ExtendOperator(String symbol) {
        this.symbol = symbol;
    }


    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}