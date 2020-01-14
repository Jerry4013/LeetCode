package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if(nums.length==0)
            return result;

        permuteHelper(nums, nums.length, nums.length, result);
        return result;
    }

    public void permuteHelper(int[] nums, int size, int n, List<List<Integer>> result) {

        if(size == 1) { // add combo in list
            List<Integer> combo = new LinkedList<>();
            for(int i = 0; i < nums.length; i++) {
                combo.add(nums[i]);
            }
            result.add(combo);
        }

        for(int i = 0; i < size; i++) {
            permuteHelper(nums, size-1, n, result);

            if(size%2==1) {
                int temp = nums[0];
                nums[0] = nums[size-1];
                nums[size-1] = temp;
            } else {
                int temp = nums[i];
                nums[i] = nums[size-1];
                nums[size-1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new P46_Permutations().permute(new int[]{1, 2, 3});
        System.out.println("permute = " + permute);
    }
}
