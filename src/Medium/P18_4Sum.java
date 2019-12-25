package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    if (nums[i] + nums[j] + nums[l] + nums[r] == target) {
                        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        res.add(list);
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r + 1]) {
                            r--;
                        }
                    } else if (nums[i] + nums[j] + nums[l] + nums[r] < target) {
                        l++;
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                    } else {
                        r--;
                        while (l < r && nums[r] == nums[r + 1]) {
                            r--;
                        }
                    }
                }
                while (j + 1 < nums.length - 2 && nums[j + 1] == nums[j]) {
                    j++;
                }
            }
            while (i + 1 < nums.length - 3 && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new P18_4Sum().fourSum(new int[]{-1, -5, -5, -3, 2, 5, 0, 4}, -7);
        System.out.println("lists = " + lists);
    }
}
