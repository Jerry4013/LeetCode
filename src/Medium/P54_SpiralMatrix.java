package Medium;

import java.util.ArrayList;
import java.util.List;

public class P54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) {
            return ans;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = n - 1, t = 0, b = m - 1, i = 0, j = 0;
        int d = 0;
        while (ans.size() < m * n) {
            if (d % 4 == 0) {
                while (j <= r) {
                    ans.add(matrix[i][j]);
                    j++;
                }
                j--;
                i++;
                t++;
            } else if (d % 4 == 1) {
                while (i <= b) {
                    ans.add(matrix[i][j]);
                    i++;
                }
                i--;
                j--;
                r--;
            } else if (d % 4 == 2) {
                while (j >= l) {
                    ans.add(matrix[i][j]);
                    j--;
                }
                j++;
                i--;
                b--;
            } else if (d % 4 == 3) {
                while (i >= t) {
                    ans.add(matrix[i][j]);
                    i--;
                }
                i++;
                j++;
                l++;
            }
            d++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> list = new P54_SpiralMatrix().spiralOrder(matrix);
        System.out.println("list = " + list);
    }
}
