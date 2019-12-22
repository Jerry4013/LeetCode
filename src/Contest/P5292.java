package Contest;

import java.util.*;

public class P5292 {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer value = map.getOrDefault(num, 0);
            map.put(num, value + 1);
        }

        for (int i = 0; i < nums.length / k; i++) {
            if (map.size() == 0) {
                return false;
            }
            Set<Integer> keys = map.keySet();
            ArrayList<Integer> sortedKeys = new ArrayList<>(keys);
            int key = sortedKeys.get(0);
            for (int j = 0; j < k; j++) {
                Integer value = map.get(key);
                if (value == null || value == 0) {
                    return false;
                }
                if (value == 1) {
                    map.remove(key);
                } else {
                    map.put(key, value - 1);
                }
                key++;
            }
        }
        return true;
    }
}
