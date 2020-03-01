package Medium;

import java.util.HashMap;

public class P166_FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return "";
        }
        if (numerator == 0) {
            return "0";
        }
        boolean negative = false;
        long numeratorLong = numerator, denominatorLong = denominator;
        if (numerator < 0 && denominator > 0) {
            negative = true;
            numeratorLong = -(long)numerator;
        } else if (numerator > 0 && denominator < 0) {
            negative = true;
            denominatorLong = -(long)denominator;
        } else if (numerator < 0) {
            numeratorLong = -(long)numerator;
            denominatorLong = -(long)denominator;
        }
        StringBuilder sb = new StringBuilder();
        if (numeratorLong > denominatorLong && numeratorLong % denominatorLong == 0) {
            return negative ? String.valueOf(-numeratorLong / denominatorLong) : String.valueOf(numeratorLong / denominatorLong);
        }
        sb.append(numeratorLong / denominatorLong).append(".");
        long remainder = numeratorLong % denominatorLong;
        HashMap<Long, Integer> map = new HashMap<>();
        int count = sb.length();
        while (remainder > 0 && count < 50) {
            if (map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }
            map.put(remainder, count);
            remainder *= 10;
            while (remainder < denominatorLong) {
                remainder *= 10;
                sb.append("0");
                count++;
            }
            sb.append(remainder / denominatorLong);
            count++;
            remainder = remainder % denominatorLong;
        }
        if (negative) {
            return "-" + sb.toString();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new P166_FractiontoRecurringDecimal().fractionToDecimal(-2147483648, 1);
        System.out.println("s = " + s);
    }
}
