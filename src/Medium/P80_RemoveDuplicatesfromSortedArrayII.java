package Medium;

import java.util.Arrays;

public class P80_RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 2) {
            return length;
        }
        int i = 2;
        while (i < length && (nums[i] != nums[i - 1] || nums[i] != nums[i - 2])) {
            i++;
        }
        int j = i + 1;
        while (j < length) {
            if (nums[j] == nums[i - 1] && nums[j] == nums[i - 2]) {
                j++;
            } else {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j++] = temp;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 2};
        int i = new P80_RemoveDuplicatesfromSortedArrayII().removeDuplicates(test);
        System.out.println("i = " + i);
        System.out.println("test = " + Arrays.toString(test));
    }
}
