package Medium;

import java.util.Arrays;

public class P16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            int sum = target - nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == sum) {
                    return target;
                } else if (nums[l] + nums[r] < sum) {
                    if (Math.abs(sum - nums[l] - nums[r]) < diff) {
                        res = nums[i] + nums[l] + nums[r];
                        diff = Math.abs(sum - nums[l] - nums[r]);
                    }
                    l++;
                } else {
                    if (Math.abs(sum - nums[l] - nums[r]) < diff) {
                        res = nums[i] + nums[l] + nums[r];
                        diff = Math.abs(sum - nums[l] - nums[r]);
                    }
                    r--;
                }
            }
        }
        return res;
    }
}
