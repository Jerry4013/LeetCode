package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P244_ShortestWordDistanceII {
    HashMap<String, List<Integer>> map;
    public P244_ShortestWordDistanceII(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            List<Integer> list = map.getOrDefault(words[i], new ArrayList<>());
            list.add(i);
            map.put(words[i], list);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int i = 0, j = 0;
        int size1 = list1.size();
        int size2 = list2.size();
        int shortest = Integer.MAX_VALUE;
        while (i < size1 && j < size2) {
            Integer curr1 = list1.get(i);
            Integer curr2 = list2.get(j);
            if (curr1 < curr2) {
                shortest = Math.min(shortest, curr2 - curr1);
                i++;
            } else {
                shortest = Math.min(shortest, curr1 - curr2);
                j++;
            }
        }
        return shortest;
    }
}
