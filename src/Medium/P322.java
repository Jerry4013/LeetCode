package Medium;

import java.util.Arrays;

/**
 * Created by Jingchao Zhang
 * Date: 2020-11-29
 * Time: 12:09 AM
 */
public class P322 {
    int ans = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        if (dfs(coins, amount, 0)) {
            return ans;
        }
        return -1;
    }

    public boolean dfs(int[] coins, int amount, int used) {
        if (amount < 0) {
            return false;
        }
        if (amount == 0) {
            ans = Math.min(ans, used);
            return true;
        }
        boolean flag = false;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (dfs(coins, amount - coins[i], used + 1)) {
                flag = true;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int i = new P322().coinChange(new int[]{186, 419, 83, 408}, 6249);
        System.out.println("i = " + i);
    }
}
