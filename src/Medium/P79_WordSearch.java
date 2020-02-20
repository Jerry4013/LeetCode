package Medium;

import java.util.HashSet;
import java.util.Set;

public class P79_WordSearch {
    Set<Integer> visited = new HashSet<>();
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited.clear();
                    if (DFS(board, word, 1, i * n + j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean DFS(char[][] board, String word, int start, int index) {
        if (start == word.length()) {
            return true;
        }
        visited.add(index);
        char current = word.charAt(start);
        int m = board.length;
        int n = board[0].length;
        if (index >= n) {
            int up = index - n;
            if (!visited.contains(up)) {
                if (board[up / n][up % n] == current) {
                    if (DFS(board, word, start + 1, up)) {
                        return true;
                    } else {
                        visited.remove(up);
                    }
                }
            }
        }
        if (index % n > 0) {
            int left = index - 1;
            if (!visited.contains(left)) {
                if (board[left / n][left % n] == current) {
                    if (DFS(board, word, start + 1, left)) {
                        return true;
                    } else {
                        visited.remove(left);
                    }
                }
            }
        }
        if (index + n < m * n) {
            int down = index + n;
            if (!visited.contains(down)) {
                if (board[down / n][down % n] == current) {
                    if (DFS(board, word, start + 1, down)) {
                        return true;
                    } else {
                        visited.remove(down);
                    }
                }
            }
        }
        if (index % n < n - 1) {
            int right = index + 1;
            if (!visited.contains(right)) {
                if (board[right / n][right % n] == current) {
                    if (DFS(board, word, start + 1, right)) {
                        return true;
                    } else {
                        visited.remove(right);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] test = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        boolean abceseeefs = new P79_WordSearch().exist(test, "ABCESEEEFS");
        System.out.println("abceseeefs = " + abceseeefs);
    }
}
