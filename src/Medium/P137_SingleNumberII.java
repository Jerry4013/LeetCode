package Medium;

import java.util.HashSet;

public class P137_SingleNumberII {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> repeated = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
                repeated.add(num);
            } else if (!repeated.contains(num)) {
                set.add(num);
            }
        }
        for (Integer integer : set) {
            return integer;
        }
        return 0;
    }
}
