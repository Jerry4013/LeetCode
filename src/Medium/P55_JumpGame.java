package Medium;

public class P55_JumpGame {
    public boolean canJump(int[] nums) {
        boolean[] memo = new boolean[nums.length];
        dfs(nums, memo, 0);
        return memo[nums.length - 1];
    }

    private void dfs(int[] nums, boolean[] memo, int start) {
        memo[start] = true;
        int l = Math.max(0, start - nums[start]);
        int r = Math.min(nums.length - 1, start + nums[start]);
        while (l <= r) {
            if (l != start && !memo[l]) {
                dfs(nums, memo, l);
            }
            l++;
        }
    }

    public static void main(String[] args) {
        boolean b = new P55_JumpGame().canJump(new int[]{3, 2, 1, 0, 4});
        System.out.println("b = " + b);
    }
}
