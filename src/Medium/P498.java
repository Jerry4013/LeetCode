package Medium;

import java.util.Arrays;

/**
 * Created by Jingchao Zhang
 * Date: 2020-12-25
 * Time: 9:43 AM
 */
public class P498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new int[0];
        }
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int index = 0;
        boolean toRightTop = true;
        int start;
        for (int sum = 0; sum <= (m - 1) + (n - 1); sum++) {
            if (toRightTop) {
                start = sum > m - 1 ? sum - m + 1 : 0;
                for (int j = start; sum - j >= 0 && j < n; j++) {
                    res[index++] = matrix[sum - j][j];
                }
            } else {
                start = sum > n - 1 ? sum - n + 1 : 0;
                for (int i = start; sum - i >= 0 && i < m; i++) {
                    res[index++] = matrix[i][sum - i];
                }
            }
            toRightTop = !toRightTop;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] test = {{2,3}};
        int[] diagonalOrder = new P498().findDiagonalOrder(test);
        System.out.println("diagonalOrder = " + Arrays.toString(diagonalOrder));
    }
}
