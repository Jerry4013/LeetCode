package Contest;

import java.util.ArrayList;
import java.util.List;

public class P5316 {
    public List<String> printVertically(String s) {
        String[] split = s.split(" ");
        int maxLength = 0;
        for (String word : split) {
            maxLength = Math.max(maxLength, word.length());
        }
        StringBuilder[] ans = new StringBuilder[maxLength];
        for (int i = 0; i < maxLength; i++) {
            ans[i] = new StringBuilder();
            for (String word : split) {
                if (i >= word.length()) {
                    ans[i].append(' ');
                } else {
                    ans[i].append(word.charAt(i));
                }
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < maxLength; i++) {
            String string = ans[i].toString();
            int len = string.length();
            for (; len > 0; len--) {
                if (!Character.isWhitespace(string.charAt(len - 1)))
                    break;
            }
            list.add(string.substring(0, len));
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> how_are_you = new P5316().printVertically("TO BE OR NOT TO BE");
        System.out.println("how_are_you = " + how_are_you);
    }
}
