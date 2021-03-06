package Medium;

import java.util.ArrayList;
import java.util.List;

public class P241_DifferentWaystoAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return result;
        }
        List<String> ops = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            int j = i;
            while (j < input.length() && Character.isDigit(input.charAt(j))) {
                j++;
            }
            ops.add(input.substring(i, j));
            if (j != input.length()) {
                ops.add(input.substring(j, j + 1));
            }
            i = j;
        }
        int N = (ops.size() + 1) / 2;
        ArrayList<Integer>[][] dp = (ArrayList<Integer>[][]) new ArrayList[N][N];
        for (int d = 0; d < N; d++) {
            if (d == 0) {
                for (int i = 0; i < N; i++) {
                    dp[i][i] = new ArrayList<>();
                    dp[i][i].add(Integer.valueOf(ops.get(i * 2)));
                }
                continue;
            }
            for (int i = 0; i < N - d; i++) {
                dp[i][i + d] = new ArrayList<>();
                for (int j = i; j < i + d; j++) {
                    ArrayList<Integer> left = dp[i][j];
                    ArrayList<Integer> right = dp[j + 1][i + d];
                    String operator = ops.get(j * 2 + 1);
                    for (Integer leftNum : left) {
                        for (Integer rightNum : right) {
                            if (operator.equals("+")) {
                                dp[i][i + d].add(leftNum + rightNum);
                            } else if (operator.equals("-")) {
                                dp[i][i + d].add(leftNum - rightNum);
                            } else {
                                dp[i][i + d].add(leftNum * rightNum);
                            }
                        }
                    }
                }
            }
        }
        return dp[0][N - 1];
    }
}




