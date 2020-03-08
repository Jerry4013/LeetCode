package Contest;

import java.util.HashMap;

public class P5337 {
    public int findTheLongestSubstring(String s) {
        int mask = 0;
        int best = 0;
        HashMap<Integer, Integer> pos = new HashMap<>();
        pos.put(0, -1);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int offset = getOffset(chars[i]);
            mask ^= offset;
            if (!pos.containsKey(mask)) {
                pos.put(mask, i);
            } else {
                best = Math.max(best, i - pos.get(mask));
            }
        }
        return best;
    }

    private int getOffset(char c) {
        if (c == 'a') {
            return 1;
        }
        if (c == 'e') {
            return 2;
        }
        if (c == 'i') {
            return 4;
        }
        if (c == 'o') {
            return 8;
        }
        if (c == 'u') {
            return 16;
        }
        return 0;
    }

    public static void main(String[] args) {
        int eleetminicoworoep = new P5337().findTheLongestSubstring("leetcodeisgreat");
        System.out.println(eleetminicoworoep);

    }
}
