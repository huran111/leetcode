package hr_01;


/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-06-21 15:28
 */
public class Main {
    public static int flb(int n) {
        if (n <= 1) return n;
        return flb(n - 1) + flb(n - 2);
    }

    public static int flb2(int n) {
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
        for (int i = 0; i < n; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    public static int fib3(int n) {
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
        while (n-- > 1) {
            second += first;
            first = second - first;
        }
        return second;
    }

    /**
     * O(1)
     *
     * @param n
     * @return
     */
    public static int fib4(int n) {
        double c = Math.sqrt(5);
        return (int) ((Math.pow((1 + c) / 2, n) - Math.pow((1 - c) / 2, n)) / c);
    }

    public static void main(String[] args) {
        Times.test("flb", new Times.Task() {
            @Override
            public void execute() {
                flb(40);
            }
        });
        Times.test("flb2", new Times.Task() {
            @Override
            public void execute() {
                flb2(40);
            }
        });
    }
}