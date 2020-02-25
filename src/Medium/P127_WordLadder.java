package Medium;

import java.util.*;

public class P127_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);
        if (!wordDict.contains(endWord)) {
            return 0;
        }
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        return helper(wordDict, begin, end, 1);
    }
    int helper(Set<String> wordDict, Set<String> begin, Set<String> end, int level) {
        if (begin.isEmpty() || end.isEmpty()) {
            return 0;
        }
        if (begin.size() > end.size()) {
            return helper(wordDict, end, begin, level);
        }
        wordDict.removeAll(begin);
        Set<String> next = new HashSet<>();
        for (String word : begin) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char old = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String newWord = new String(chars);
                    if (!wordDict.contains(newWord)) {
                        continue;
                    }
                    if (end.contains(newWord)) {
                        return level + 1;
                    }
                    next.add(newWord);
                }
                chars[i] = old;
            }
        }
        return helper(wordDict, next, end, level + 1);
    }

    public static void main(String[] args) {
        int i = new P127_WordLadder().ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println("i = " + i);
    }
}
