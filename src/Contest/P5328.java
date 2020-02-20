package Contest;

import java.util.ArrayList;
import java.util.List;

public class P5328 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        List<Integer>[] lists = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            if (mat[i][0] == 0) {
                lists[0].add(i);
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && (j == n - 1 || mat[i][j + 1] == 0)) {
                    lists[j + 1].add(i);
                }
            }
        }
        int[] ans = new int[k];
        int i = 0;
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                if (i < k) {
                    ans[i] = integer;
                    i++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] test = {{1,0},{0,0},{1,0}};
        int[] ints = new P5328().kWeakestRows(test, 2);

    }
}
