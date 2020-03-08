package Medium;

import java.util.Arrays;

public class P215_KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int j = nums.length;
        for (int i = 0; i < k; i++) {
            j--;
        }
        return nums[j];
    }
}
