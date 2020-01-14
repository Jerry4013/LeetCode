package Medium;

import java.util.*;

public class P49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Word, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Word word = new Word(str);
            List<String> list = map.getOrDefault(word, new ArrayList<>());
            list.add(str);
            map.put(word, list);
        }
        return new ArrayList<>(map.values());
    }

    static class Word {
        int[] freq;
        public Word(String s) {
            freq = new int[26];
            char[] chars = s.toCharArray();
            for (char c : chars) {
                freq[c - 'a']++;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Word word = (Word) o;
            return Arrays.equals(freq, word.freq);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(freq);
        }
    }

    public static void main(String[] args) {
        List<List<String>> lists = new P49_GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println("lists = " + lists);
    }
}
