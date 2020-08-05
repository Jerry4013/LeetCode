package Medium;

import java.util.Arrays;

public class Test {
    public String stringShift(String s, int[][] shift) {
        int count = 0;
        for (int[] sh : shift) {
            count += sh[0] == 0 ? sh[1] : -sh[1];
        }
        char[] chars = s.toCharArray();
        char[] ans = new char[chars.length];
        count %= chars.length;
        if (count > 0) {
            System.arraycopy(chars, count, ans, 0, chars.length - count);
            System.arraycopy(chars, 0, ans, chars.length - count, count);
        } else {
            System.arraycopy(chars, 0, ans, -count, chars.length + count);
            System.arraycopy(chars, chars.length + count, ans, 0, -count);
        }
        return new String(ans);
    }
}
