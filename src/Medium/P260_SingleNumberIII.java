package Medium;

import java.util.HashSet;

public class P260_SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int[] ans = new int[2];
        int i = 0;
        for (Integer integer : set) {
            ans[i] = integer;
            i++;
        }
        return ans;
    }
}
