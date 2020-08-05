package Easy;

import java.util.Arrays;

public class P844_BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        String s = read(S);
        String t = read(T);
        return s.equals(t);
    }
    private String read(String s) {
        char[] chars = s.toCharArray();
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '#') {
                chars[j] = chars[i];
                j++;
            } else if (j > 0) {
                j--;
            }
        }
        char[] ans = new char[j];
        System.arraycopy(chars, 0, ans, 0, j);
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        boolean b = new P844_BackspaceStringCompare().backspaceCompare("ab#c", "ad#c");
        System.out.println("b = " + b);

    }
}
