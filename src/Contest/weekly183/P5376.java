package Contest.weekly183;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P5376 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        List<Integer> ans = new ArrayList<>();
        int subSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            subSum += nums[i];
            ans.add(nums[i]);
            if (subSum > sum / 2) {
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> list = new P5376().minSubsequence(new int[]{6});
        System.out.println("list = " + list);
    }
}
