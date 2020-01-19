package Medium;

import java.util.ArrayList;
import java.util.List;

public class P77_Combinations {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        backtrack(nums, 0, new ArrayList<>(), k);
        return ans;
    }

    private void backtrack(int[] nums, int start, List<Integer> tempList, int k) {
        if (tempList.size() == k) {
            ans.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(nums, i + 1, tempList, k);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = new P77_Combinations().combine(4, 2);
        System.out.println("combine = " + combine);
    }
}
