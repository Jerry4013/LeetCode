package Medium;

import java.util.*;

public class P347_TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));

        pq.addAll(map.keySet());
        while (pq.size() > k) {
            pq.poll();
        }
        return new ArrayList<>(pq);
    }
}
