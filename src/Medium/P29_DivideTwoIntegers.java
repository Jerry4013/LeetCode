package Medium;

public class P29_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        boolean negative = false;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            negative = true;
        }
        String dividendString = String.valueOf(Math.abs((long)dividend));
        long newDivisor = Math.abs((long)divisor);
        String divisorString = String.valueOf(newDivisor);
        int length = divisorString.length();

        StringBuilder sb = new StringBuilder();

        while (dividendString.length() > 0 && Long.parseLong(dividendString) >= newDivisor) {
            long currentDigit = 0, temp = newDivisor;
            long curDividend = Integer.parseInt(dividendString.substring(0, length));
            boolean borrow = false;
            if (curDividend < newDivisor) {
                borrow = true;
                curDividend = Integer.parseInt(dividendString.substring(0, length + 1));
            }
            while (temp <= curDividend) {
                currentDigit++;
                temp += newDivisor;
            }
            sb.append(currentDigit);
            temp -= newDivisor;
            dividendString = (curDividend - temp == 0 ? "" : (curDividend - temp)) +
                    dividendString.substring(borrow ? (length + 1) : length);
        }
        if (sb.length() == 0) {
            return 0;
        }
        long ans = Long.parseLong(sb.toString());
        long res = negative ? (-ans) : ans;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) (res);
    }

    public static void main(String[] args) {
        int divide = new P29_DivideTwoIntegers().divide(1, 2);
        System.out.println("divide = " + divide);
    }
}
