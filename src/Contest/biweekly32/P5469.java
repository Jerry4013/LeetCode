package Contest.biweekly32;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jingchao Zhang
 * Date: 2020-08-08
 * Time: 11:31 AM
 */
public class P5469 {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int move = (t.charAt(i) - s.charAt(i) + 26) % 26;
            count[move]++;
        }
        for (int i = 0; i < 26; i++) {
            if (i + (count[i] - 1) * 26 > k) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = new P5469().canConvertString("atmtxzjkz", "tvbtjhvjd", 35);
        System.out.println("b = " + b);
    }
}
