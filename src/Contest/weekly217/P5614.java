package Contest.weekly217;

import java.util.Arrays;

/**
 * Created by Jingchao Zhang
 * Date: 2020-11-28
 * Time: 10:26 PM
 */
public class P5614 {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] ans = new int[k];
        Arrays.fill(ans, Integer.MAX_VALUE);
        int start = 0;
        for (int i = 0; i < k; i++) {
            int minPosition = nums.length - k;
            for (int j = nums.length - k + i; j >= start; j--) {
                if (nums[j] <= ans[i]) {
                    ans[i] = nums[j];
                    minPosition = j;
                }
            }
            start = minPosition + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = new P5614().mostCompetitive(new int[]{2,4,3,3,5,4,9,6}, 4);
        System.out.println("ints = " + Arrays.toString(ints));
    }
}
