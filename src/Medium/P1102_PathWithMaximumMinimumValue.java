package Medium;

public class P1102_PathWithMaximumMinimumValue {
    public int maximumMinimumPath(int[][] A) {
        int r = A.length;
        int c = A[0].length;
        int[][] min = new int[r][c];
        int[][] max = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                min[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                max[i][j] = Integer.MIN_VALUE;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int temp;
                if (i > 0) {
                    temp = Math.min(min[i - 1][j], A[i][j]);
                    min[i][j] = Math.min(temp, min[i][j]);
                }
                if (i < r - 1) {
                    temp = Math.min(min[i + 1][j], A[i][j]);
                    min[i][j] = Math.min(temp, min[i][j]);
                }
                if (j > 0 ) {
                    temp = Math.min(min[i][j - 1], A[i][j]);
                    min[i][j] = Math.min(temp, min[i][j]);
                }
                if (j < c - 1) {
                    temp = Math.min(min[i][j + 1], A[i][j]);
                    min[i][j] = Math.min(temp, min[i][j]);
                }
                max[i][j] = Math.max(max[i][j], min[i][j]);
            }
        }
        return max[r - 1][c - 1];
    }

    public static void main(String[] args) {
        int[][] test = {{5,4,5},{1,2,6},{7,4,6}};
        int i = new P1102_PathWithMaximumMinimumValue().maximumMinimumPath(test);
        System.out.println("i = " + i);
    }
}
