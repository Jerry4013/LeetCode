package Medium;

import java.util.Arrays;

public class P957_PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if (N == 0) {
            return cells;
        }
        boolean[] init = new boolean[8];
        for (int i = 1; i < cells.length - 1; i++) {
            if (cells[i - 1] == cells[i + 1]) {
                init[i] = true;
            }
        }

        for (int i = 1; i < N; i++) {
            boolean[] temp = new boolean[8];
            for (int j = 1; j < temp.length - 1; j++) {
                if (init[j - 1] == init[j + 1]) {
                    temp[j] = true;
                }
            }
            init = temp;
        }
        int[] ans = new int[8];
        for (int i = 0; i < ans.length; i++) {
            if (init[i]) {
                ans[i] = 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = new P957_PrisonCellsAfterNDays().prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7);
        System.out.println("ints = " + Arrays.toString(ints));
    }
}
