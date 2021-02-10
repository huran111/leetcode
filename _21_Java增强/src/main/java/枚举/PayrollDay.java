package 枚举;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-01-31 15:30
 */
public enum PayrollDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);
    private final PayType payType;

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    PayrollDay() {
        this(PayType.WEEKDAY);
    }

    int pay(int minuteWorked, int payRate) {
        return payType.pay(minuteWorked, payRate);
    }

    private enum PayType {
        WEEKDAY {
            @Override
            int overtimePay(int imns, int payRate) {
                return 0;
            }
        },
        WEEKEND{
            @Override
            int overtimePay(int imns, int payRate) {
                return 0;
            }
        };
        private static final int MINS_PRE_SHIEF = 8 * 60;

        abstract int overtimePay(int imns, int payRate);

        int pay(int minsWorked, int payRete) {
            int basePay = minsWorked * payRete;
            return basePay + overtimePay(minsWorked, payRete);
        }
        }
}