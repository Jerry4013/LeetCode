package Medium;

import java.util.Arrays;

public class P59_SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int last = n * n, i = 0, j = 0, current = 1, round = 0, size = n, limit = size == 1 ? 1 : (size - 1) * 4;
        int[][] ans = new int[n][n];
        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};
        while (current <= last) {
            while (i < (n + size) / 2 && j < (n + size) / 2 &&
                    i >= (n - size) / 2 && j >= (n - size) / 2 && current <= limit ) {
                ans[i][j] = current;
                current++;
                i += di[round % 4];
                j += dj[round % 4];
            }
            i -= di[round % 4];
            j -= dj[round % 4];
            round++;
            i += di[round % 4];
            j += dj[round % 4];
            if (round % 4 == 0) {
                size -= 2;
                limit += size == 1 ? 1 :(size - 1) * 4;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] ints = new P59_SpiralMatrixII().generateMatrix(1);
        System.out.println("ints = " + Arrays.deepToString(ints));
    }
}
