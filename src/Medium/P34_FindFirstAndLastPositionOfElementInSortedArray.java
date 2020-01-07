package Medium;

import java.util.Arrays;

public class P34_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int i = binarySearch(nums, target);
        if (i == -1) {
            return new int[] {-1, -1};
        }
        int l = i, r = i;
        while (l > 0 && nums[l-1] == target) {
            l--;
        }
        while (r < nums.length - 1 && nums[r+1] == target) {
            r++;
        }
        ans[0] = l;
        ans[1] = r;
        return ans;
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = new P34_FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{1}, 1);
        System.out.println("ints = " + Arrays.toString(ints));

    }
}
