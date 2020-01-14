package Medium;

import java.util.ArrayList;
import java.util.List;

public class P39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combinationSum(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }

    private void combinationSum(List<List<Integer>> ans, List<Integer> tempList, int[] candidates, int target, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(tempList));
            return;
        }
        if (target < 0 || start == candidates.length) {
            return;
        }
        if (candidates[start] <= target) {
            tempList.add(candidates[start]);
            combinationSum(ans, tempList, candidates, target - candidates[start], start);
            tempList.remove(tempList.size() - 1);
        }
        combinationSum(ans, tempList, candidates, target, start + 1);
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new P39_CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println("lists = " + lists);
    }
}
