package Contest;

import java.util.Arrays;

public class P5303 {
    public String freqAlphabets(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (i + 2 < chars.length && chars[i+2] == '#') {
                char[] n = Arrays.copyOfRange(chars, i, i + 2);
                sb.append((char) (Integer.parseInt(new String(n)) + 'a' - 1));
                i = i + 2;
            } else {
                sb.append((char) (chars[i] - '0' + 'a' - 1));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new P5303().freqAlphabets("10#11#12");
        System.out.println("s = " + s);
    }
}
