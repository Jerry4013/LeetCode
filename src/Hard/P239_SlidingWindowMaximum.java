package Hard;

import java.util.Arrays;

public class P239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return new int[0];
        }
        int[] ans = new int[len - k + 1];
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < k; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        ans[0] = max;
        for (int i = 1; i < ans.length; i++) {
            int newValue = nums[i + k - 1];
            if (newValue >= max) {
                max = newValue;
                ans[i] = newValue;
                maxIndex = i + k - 1;
            } else if (maxIndex < i) {
                max = Integer.MIN_VALUE;
                for (int j = i; j < i + k; j++) {
                    if (nums[j] > max) {
                        max = nums[j];
                        maxIndex = j;
                    }
                }
                ans[i] = max;
            } else {
                ans[i] = max;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = new P239_SlidingWindowMaximum().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println("ints = " + Arrays.toString(ints));

    }
}
