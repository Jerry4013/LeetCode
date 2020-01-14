package Contest;

public class P5144 {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = sumSubMatrix(mat, i - K, i + K, j - K, j + K);
            }
        }
        return ans;
    }

    private int sumSubMatrix(int[][] mat, int rs, int re, int cs, int ce) {
        int ans = 0;
        if (rs < 0) rs = 0;
        if (cs < 0) cs = 0;
        if (re > mat.length - 1) re = mat.length - 1;
        if (ce > mat[0].length - 1) ce = mat[0].length - 1;
        for (int i = rs; i <= re; i++) {
            for (int j = cs; j <= ce; j++) {
                ans += mat[i][j];
            }
        }
        return ans;
    }
}
