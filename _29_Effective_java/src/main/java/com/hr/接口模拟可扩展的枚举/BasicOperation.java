package com.hr.接口模拟可扩展的枚举;

/**
 * <p>
 *     虽然枚举类型不是可扩展的，但是接口类型是可扩展的 它是用来表示api中的操作的接口类型。
 * </p>
 */
public enum BasicOperation implements Operation {
    PLSU("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };
    private final String symbol;

    BasicOperation(String symbol) {
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
