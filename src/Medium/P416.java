package Medium;

/**
 * Created by Jingchao Zhang
 * Date: 2020-11-27
 * Time: 9:16 AM
 */
public class P416 {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        // find sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }
        // if totalSum is odd,it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0) return false;
        int subSetSum = totalSum / 2;
        int n = nums.length;
        return dfs(nums, n - 1, subSetSum);
    }

    public boolean dfs(int[] nums, int n, int subSetSum) {
        // Base Cases
        if (subSetSum == 0)
            return true;
        if (n == 0 || subSetSum < 0)
            return false;
        return dfs(nums, n - 1, subSetSum - nums[n]) || dfs(nums, n - 1, subSetSum);
    }

    public static void main(String[] args) {
        boolean b = new P416().canPartition(new int[]{2,1,3,4,2});
        System.out.println("b = " + b);
    }
}
