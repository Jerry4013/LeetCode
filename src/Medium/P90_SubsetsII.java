package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P90_SubsetsII {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), 0);
        return ans;
    }

    private void backtrack(int[] nums, List<Integer> tempList, int start) {
        ans.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            backtrack(nums, tempList, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new P90_SubsetsII().subsetsWithDup(new int[]{1, 2, 2});
        System.out.println("lists = " + lists);
    }
}
