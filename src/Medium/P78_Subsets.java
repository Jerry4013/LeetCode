package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P78_Subsets {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ans;
        }
        ans.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = ans.size();
            for (int j = 0; j < size; j++) {
                List<Integer> existing = ans.get(j);
                ArrayList<Integer> newList = new ArrayList<>(existing);
                newList.add(nums[i]);
                ans.add(newList);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = new P78_Subsets().subsets(new int[]{1, 2, 3});
        System.out.println("subsets = " + subsets);
    }


}
