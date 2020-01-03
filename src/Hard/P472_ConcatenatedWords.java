package Hard;

import java.util.*;

public class P472_ConcatenatedWords {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>(10000);
        List<String> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            set.add(word);
            min = Math.min(min, word.length());
        }
        for (String word : words) {
            if (check(set, word, 0, min)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean check(Set<String> set, String word, int start, int min) {
        for (int i = start + min; i <= word.length() - min; i++) {
            if (set.contains(word.substring(start, i)) &&
                    (set.contains(word.substring(i)) || check(set, word, i, min))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> allConcatenatedWordsInADict =
                new P472_ConcatenatedWords().findAllConcatenatedWordsInADict(
                new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog",
                        "hippopotamuses", "rat", "ratcatdogcat"});
        System.out.println("allConcatenatedWordsInADict = " + allConcatenatedWordsInADict);
    }
}
