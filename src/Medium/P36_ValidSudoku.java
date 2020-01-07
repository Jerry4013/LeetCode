package Medium;

public class P36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (!checkRowOrColumn(board, true)) {
            return false;
        }
        if (!checkRowOrColumn(board, false)) {
            return false;
        }
        for (int i = 0; i < 9; i++) {
            if (!checkSub(board, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSub(char[][] board, int boxNumber) {
        int row = (boxNumber / 3) * 3;
        int col = (boxNumber % 3) * 3;
        boolean[] test = new boolean[9];
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int index = c - '1';
                if (test[index]) {
                    return false;
                }
                test[index] = true;
            }
        }
        return true;
    }

    private boolean checkRowOrColumn(char[][] board, boolean row) {
        for (int i = 0; i < 9; i++) {
            boolean[] test = new boolean[9];
            for (int j = 0; j < 9; j++) {
                char c;
                if (row) {
                    c = board[i][j];
                } else {
                    c = board[j][i];
                }
                if (c == '.') {
                    continue;
                }
                int index = c - '1';
                if (test[index]) {
                    return false;
                }
                test[index] = true;
            }
        }
        return true;
    }
}
