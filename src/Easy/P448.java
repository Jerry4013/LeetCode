package Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jingchao Zhang
 * Date: 2020-11-11
 * Time: 5:22 PM
 */
public class P448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num : nums) {
            nums[Math.abs(num) - 1] = -Math.abs(nums[Math.abs(num) - 1]);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> disappearedNumbers = new P448().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(disappearedNumbers);
    }
}
