package Medium;

import java.util.List;

public class P120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int size = triangle.size();
        int[] dp = new int[size];

        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (i == size - 1) {
                    dp[j] = triangle.get(i).get(j);
                } else {
                    dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
                }
            }
        }
        return dp[0];
    }
}
