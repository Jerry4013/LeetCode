package Medium;

import java.util.Arrays;

public class P31_NextPermutation {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int i;
        for (i = length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                int next = length - 1;
                while (nums[next] <= nums[i - 1]) {
                    next--;
                }
                int temp = nums[i - 1];
                nums[i - 1] = nums[next];
                nums[next] = temp;
                int l = i, r = length - 1;
                while (l < r) {
                    temp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = temp;
                    l++;
                    r--;
                }
                break;
            }
        }
        if (i == 0) {
            Arrays.sort(nums);
        }
    }

    public static void main(String[] args) {
        int[] test = {4,1,3,5,2};
        new P31_NextPermutation().nextPermutation(test);
        System.out.println("test = " + Arrays.toString(test));

    }
}
