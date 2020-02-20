package Medium;

public class P74_Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midElement = matrix[mid / n][mid % n];
            if (target == midElement) {
                return true;
            } else if (target < midElement) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
