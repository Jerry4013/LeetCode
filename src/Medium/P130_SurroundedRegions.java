package Medium;

import java.util.ArrayList;
import java.util.List;

public class P130_SurroundedRegions {

    boolean capture = true;
    int m;
    int n;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    capture = true;
                    List<Integer> visited = new ArrayList<>();
                    dfs(board, i, j, visited);
                    if (capture) {
                        for (Integer visitedIndex : visited) {
                            int r = visitedIndex / n;
                            int c = visitedIndex % n;
                            board[r][c] = 'X';
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, List<Integer> visited) {
        board[i][j] = 'V';
        visited.add(i * n + j);
        if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
            capture = false;
            return;
        }
        if (board[i - 1][j] == 'O') {
            dfs(board, i - 1, j, visited);
        }
        if (board[i + 1][j] == 'O') {
            dfs(board, i + 1, j, visited);
        }
        if (board[i][j - 1] == 'O') {
            dfs(board, i, j - 1, visited);
        }
        if (board[i][j + 1] == 'O') {
            dfs(board, i, j + 1, visited);
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},
                            {'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
        new P130_SurroundedRegions().solve(board);
    }
}





