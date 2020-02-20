package Medium;

import java.util.Arrays;

public class P75_SortColors {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        int current = 0;
        while (current <= r) {
            if (nums[current] == 2) {
                int temp = nums[current];
                nums[current] = nums[r];
                nums[r] = temp;
                r--;
            } else if (nums[current] == 0) {
                int temp = nums[current];
                nums[current++] = nums[l];
                nums[l] = temp;
                l++;
            } else {
                current++;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {2,0,2,1,1,0};
        new P75_SortColors().sortColors(test);
        System.out.println("Arrays.toString(test) = " + Arrays.toString(test));
    }
}
