package Medium;

import java.util.*;

public class P49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0) {
                    sb.append(count[i]);
                    sb.append((char)('a' + i));
                }
            }
            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(str);
            map.put(sb.toString(), list);
            sb.setLength(0);
        }
        return new ArrayList<>(map.values());
    }



    public static void main(String[] args) {
        List<List<String>> lists = new P49_GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println("lists = " + lists);
    }
}
