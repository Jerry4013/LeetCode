package Medium;

public class P8_StringtoInteger {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0 || (!str.startsWith("-") && !str.startsWith("+") && !Character.isDigit(str.charAt(0)))) {
            return 0;
        }
        char[] chars = str.toCharArray();
        boolean negative = false;
        long myInt = 0L;
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 && chars[i] == '-') {
                negative = true;
                continue;
            }
            if (i == 0 && chars[i] == '+') {
                continue;
            }
            if (!Character.isDigit(chars[i]) || myInt > Integer.MAX_VALUE) {
                break;
            }
            int digit = chars[i] - '0';
            myInt = myInt * 10 + digit;
        }
        if (negative) {
            myInt = -myInt;
        }
        if (myInt < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (myInt > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)myInt;
    }
}
