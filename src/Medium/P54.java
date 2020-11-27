package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jingchao Zhang
 * Date: 2020-11-18
 * Time: 12:19 PM
 */
public class P54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        // boundries
        int l = 1, r = matrix[0].length - 1, u = 1, b = matrix.length - 1;

        List<Integer> ans = new ArrayList<>();
        ans.add(matrix[0][0]);
        int n = matrix.length * matrix[0].length - 1;
        int i = 0, j = 1;
        while (n > 0) {
            while (n > 0 && j <= r) {
                ans.add(matrix[i][j++]);
                n--;
            }
            i++;
            j--;
            r--;
            while (n > 0 && i <= b) {
                ans.add(matrix[i++][j]);
                n--;
            }
            i--;
            j--;
            b--;
            while (n > 0 && j >= l) {
                ans.add(matrix[i][j--]);
                n--;
            }
            i--;
            j++;
            l++;
            while (n > 0 && i >= u) {
                ans.add(matrix[i--][j]);
                n--;
            }
            i++;
            j++;
            u++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] test = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> integers = new P54().spiralOrder(test);

    }

}
