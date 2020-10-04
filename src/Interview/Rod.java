package Interview;

/**
 * Created by Jingchao Zhang
 * Date: 2020-09-26
 * Time: 1:38 PM
 */
public class Rod {
    int rodCutting(int n, int[] v) {
        int[] dp = new int[v.length];
        dp[0] = v[0];
        for (int i = 1; i < v.length; i++) {
            dp[i] = v[i];
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int i = new Rod().rodCutting(4, new int[]{0, 0, 4, 7, 1});
        System.out.println("i = " + i);

    }
}
