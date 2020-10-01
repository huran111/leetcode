package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: java8-api
 * @description:
 * @author: HuRan
 * @create: 2020-09-08 09:46
 */
public class Java8ApiTest4 {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions =
                Arrays.asList(new Transaction(brian, 2011, 300),
                        new Transaction(raoul, 2012, 1000),
                        new Transaction(raoul, 2011, 400),
                        new Transaction(mario, 2012, 710),
                        new Transaction(mario, 2012, 700),
                        new Transaction(alan, 2012, 950));
        //提取与交易相关得每位交易员得所在城市
        final List<String> collect = transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(Collectors.toList());
        System.out.println(collect.toString());
        final List<Transaction> collect1 = transactions.stream().filter(transaction -> transaction.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        System.out.println(collect1.toString());
        //效率低
        final String reduce = transactions.stream().map(transaction -> transaction.getTrader().getName())
                .distinct().sorted().reduce("", (n1, n2) -> n1.concat(n2));
        final String collect2 = transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct().sorted().collect(Collectors.joining());
        System.out.println(collect2);
        final boolean s = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("S"));
        System.out.println(s);
        transactions.stream().filter(t->"A".equals(t.getTrader().getCity())).map(Transaction::getValue).forEach(System.out::println);
        //所有交易中，高的交易额是多少 Optional
        //数值流
        final Long collect3 = transactions.stream().collect(Collectors.counting());
        final long count = transactions.stream().count();
        System.out.println(count);
        System.out.println(collect3);

    }

}

class Trader {
    private final String name;
    private final String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

class Transaction {

    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return this.trader;
    }

    public int getYear() {
        return this.year;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "{" + this.trader + ", " + "year: " + this.year + ", " + "value:" + this.value + "}";
    }
}