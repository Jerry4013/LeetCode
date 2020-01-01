package Medium;

public class P29_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        //Take care the edge cases.
        if (longDivisor == 0) return Integer.MAX_VALUE;
        if ((longDividend == 0) || (longDividend < longDivisor)) {
            return 0;
        }

        long lans = ldivide(longDividend, longDivisor);

        int ans;
        if (lans > Integer.MAX_VALUE){ //Handle overflow.
            ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }

    private long ldivide(long ldividend, long ldivisor) {
        // Recursion exit condition
        if (ldividend < ldivisor) return 0;

        //  Find the largest multiple so that (divisor * multiple <= dividend),
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + ldivide(ldividend - sum, ldivisor);
    }

    public static void main(String[] args) {
        int divide = new P29_DivideTwoIntegers().divide(2147483647, 2);
        System.out.println("divide = " + divide);
    }
}
