package Medium;

public class P33_SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int l = 0;
        int r = length - 1;
        int pivot = -1;
        boolean ascending = false;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid == 0 && mid < length - 1 && nums[mid] > nums[mid + 1]) {
                pivot = mid;
                break;
            } else if (mid > 0 && nums[mid] > nums[mid - 1] && mid < length - 1 &&  nums[mid] > nums[mid + 1]) {
                pivot = mid;
                break;
            } else if (nums[mid] > nums[length - 1]) {
                l = mid + 1;
            } else if (nums[mid] < nums[length - 1]) {
                r = mid - 1;
            } else {
                pivot = length - 1;
                ascending = true;
                break;
            }
        }
        int left = bs(nums, target, 0, pivot);
        if (left != -1) {
            return left;
        }
        if (!ascending) {
            return bs(nums, target, pivot + 1, length - 1);
        }
        return -1;
    }

    private int bs(int[] nums, int target, int start, int end){
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int search = new P33_SearchinRotatedSortedArray().search(new int[]{3,1}, 1);
        System.out.println("search = " + search);
    }
}
