package Medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Jingchao Zhang
 * Date: 2020-08-23
 * Time: 11:30 PM
 */
public class P909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int s = queue.remove();
            if (s == n * n) {
                return map.get(s);
            }
            for (int s2 = s + 1; s2 <= Math.min(s + 6, n * n); s2++) {
                int rc = get(s2, n);
                int r = rc / n, c = rc % n;
                int s2Final = board[r][c] == -1 ? s2 : board[r][c];
                if (!map.containsKey(s2Final)) {
                    map.put(s2Final, map.get(s) + 1);
                    queue.add(s2Final);
                }
            }
        }
        return -1;
    }

    private int get(int s, int n) {
        int quotient = (s - 1) / n;
        int remainder = (s - 1) % n;
        int row = n - 1 - quotient;
        int col = row % 2 != n % 2 ? remainder : n - 1 - remainder;
        return row * n + col;
    }

    public static void main(String[] args) {
        int[][] board = {{-1,-1,27,13,-1,25,-1},
                        {-1,-1,-1,-1,-1,-1,-1},
                        {44,-1,8,-1,-1,2,-1},
                        {-1,30,-1,-1,-1,-1,-1},
                        {3,-1,20,-1,46,6,-1},
                        {-1,-1,-1,-1,-1,-1,29},
                        {-1,29,21,33,-1,-1,-1}};
        int i = new P909().snakesAndLadders(board);
        System.out.println("i = " + i);
    }
}
