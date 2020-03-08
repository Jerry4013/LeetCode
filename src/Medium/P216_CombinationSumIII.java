package Medium;

import java.util.*;

public class P216_CombinationSumIII {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(new ArrayList<>(), k, n, 1);
        return ans;
    }

    private void backtrack(List<Integer> tempList, int k, int n, int start) {
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(tempList));
            return;
        }
        if (k <= 0 || n <= 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            tempList.add(i);
            backtrack(tempList, k - 1, n - i, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new P216_CombinationSumIII().combinationSum3(3, 9);
        System.out.println("lists = " + lists);
    }
}
