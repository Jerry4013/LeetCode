package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P46_Permutations {
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0)
            return ans;

        permuteHelper(nums, nums.length);
        return ans;
    }

    public void permuteHelper(int[] nums, int size) {

        if(size == 1) {
            List<Integer> combo = new LinkedList<>();
            for (int num : nums) {
                combo.add(num);
            }
            ans.add(combo);
            return;
        }

        for(int i = 0; i < size; i++) {
            permuteHelper(nums, size - 1);

            if(size % 2 == 1) {
                int temp = nums[0];
                nums[0] = nums[size - 1];
                nums[size - 1] = temp;
            } else {
                int temp = nums[i];
                nums[i] = nums[size - 1];
                nums[size - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new P46_Permutations().permute(new int[]{1, 2, 3});
        System.out.println("permute = " + permute);
    }
}
