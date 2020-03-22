package Contest;

import java.util.ArrayList;
import java.util.List;

public class P5356 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            int j = 0;
            for (; j < n; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    index = j;
                }
            }
            boolean lucky = true;
            for (int k = 0; k < m; k++) {
                if (matrix[k][index] > min) {
                    lucky = false;
                    break;
                }
            }
            if (lucky) {
                ans.add(min);
            }
        }
        return ans;
    }
}
