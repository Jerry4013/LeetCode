package Medium;

public class P240_Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = n - 1;
        for (int i = 0; i < m; i++) {
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (target < matrix[i][mid]) {
                    r = mid - 1;
                } else if (mid + 1 < n && target >= matrix[i][mid + 1]) {
                    l = mid + 1;
                } else {
                    l = 0;
                    r = mid + 1;
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] test = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        boolean b = new P240_Searcha2DMatrixII().searchMatrix(
                new int[][]{{-1,3}}, 3);
        System.out.println("b = " + b);
    }
}
