package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P47_PermutationsII {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> tempList) {
        if (tempList.size() == nums.length) {
            ans.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0  && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            tempList.add(nums[i]);
            backtrack(nums, used, tempList);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new P47_PermutationsII().permuteUnique(new int[]{2, 2, 1, 1});
        System.out.println("permute = " + permute);
    }
}
