package Contest;

import java.util.Arrays;
import java.util.HashSet;

public class P5146 {
    public int distinctEchoSubstrings(String text) {
        char[] chars = text.toCharArray();
        HashSet<String> ans = new HashSet<>();
        for (int i = 0; i < chars.length - 1; i++) {
            int boundary = i + (chars.length - i) / 2;
            for (int second = i + 1; second <= boundary; second++) {
                int tempFirst = i;
                int tempSecond = second;
                while (tempFirst < second && chars[tempFirst] == chars[tempSecond]) {
                    tempFirst++;
                    tempSecond++;
                }
                if (tempFirst == second) {
                    ans.add(new String(Arrays.copyOfRange(chars, i, tempFirst)));
                }
            }
        }
        return ans.size();
    }

    public static void main(String[] args) {
        int abcabcabc = new P5146().distinctEchoSubstrings("abcabcabc");
        System.out.println("abcabcabc = " + abcabcabc);
    }
}
