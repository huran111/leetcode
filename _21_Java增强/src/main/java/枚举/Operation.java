package 枚举;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operation {
    PLSU("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MUNUS("-") {
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

    Operation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public abstract double apply(double x, double y);

    public static final Map<String, Operation> stringToEnum = Stream.of(values()).collect(Collectors.toMap(Object::toString, e -> e));

    public static Optional<Operation> formString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    public static void main(String[] args) {
        double x = Double.parseDouble("2");
        double y = Double.parseDouble("4");
        Operation[] values = Operation.values();
        for (Operation value : values) {
            System.out.printf("%f %s %f=%f%n", x, value, y, value.apply(x, y));
        }
        System.out.println(stringToEnum);
        Optional<Operation> operation = formString("-");
        Operation op = operation.get();
        System.out.println(op.toString());
    }
}
