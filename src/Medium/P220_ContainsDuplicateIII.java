package Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class P220_ContainsDuplicateIII {
    private long getID(long x, long w) {
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) {
            return false;
        }
        Map<Long, Long> d = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < nums.length; i++) {
            long m = getID(nums[i], w);
            if (d.containsKey(m)) {
                return true;
            }
            if (d.containsKey(m - 1) && nums[i] - d.get(m - 1) < w) {
                return true;
            }
            if (d.containsKey(m + 1) && d.get(m + 1) - nums[i] < w) {
                return true;
            }
            d.put(m, (long) nums[i]);
            if (i >= k) {
                d.remove(getID(nums[i - k], w));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = new P220_ContainsDuplicateIII().containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3);
        System.out.println("b = " + b);
    }
}
