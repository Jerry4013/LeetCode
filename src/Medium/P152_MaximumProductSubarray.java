package Medium;

public class P152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int curMin = nums[0];
        int curMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int min = Math.min(nums[i], Math.min(curMin * nums[i], curMax * nums[i]));
            int max = Math.max(nums[i], Math.max(curMin * nums[i], curMax * nums[i]));
            curMin = min;
            curMax = max;
            res = Math.max(res, curMax);
        }
        return res;
    }
}
