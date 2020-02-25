package Medium;

import java.util.List;

public class P139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] bad = new boolean[s.length()];
        return wordBreak(s, 0, wordDict, bad);
    }

    public boolean wordBreak(String s, int offset, List<String> wordDict, boolean[] bad) {
        if (s.length() == offset) {
            return true;
        }
        if (bad[offset]) {
            return false;
        }
        for (String dict : wordDict) {
            if (s.startsWith(dict, offset) && wordBreak(s, offset + dict.length(), wordDict, bad)) {
                return true;
            }
        }
        bad[offset] = true;
        return false;
    }
}
