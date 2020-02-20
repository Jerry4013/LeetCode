package Medium;

public class P153_FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1] || mid == 0 && nums[mid + 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] >= nums[0]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (l == nums.length) {
            return nums[0];
        }
        return l;
    }
}
