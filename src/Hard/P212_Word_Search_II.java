package Hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jingchao Zhang
 * Date: 2020-08-04
 * Time: 7:53 PM
 */
public class P212_Word_Search_II {
    private int m, n;
    private boolean[][] visited;
    private boolean exist;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        if (board.length == 0 || board[0].length == 0) {
            return ans;
        }
        m = board.length;
        n = board[0].length;
        for (String word : words) {
            if (found(board, word)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean found(char[][] board, String word) {
        visited = new boolean[m][n];
        exist = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, word, i, j);
                if (exist) {
                    return true;
                }
            }
        }
        return false;
    }

    private void dfs(char[][] board, String word, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(0)) {
            return;
        }
        visited[i][j] = true;
        if (word.length() == 1) {
            exist = true;
            return;
        }
        dfs(board, word.substring(1), i - 1, j);
        dfs(board, word.substring(1), i, j - 1);
        dfs(board, word.substring(1), i + 1, j);
        dfs(board, word.substring(1), i, j + 1);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] board = {{'a', 'b'}, {'a', 'a'}};
        String[] words = {"aaba"};
        List<String> words1 = new P212_Word_Search_II().findWords(board, words);
        System.out.println(words1);
    }
}
