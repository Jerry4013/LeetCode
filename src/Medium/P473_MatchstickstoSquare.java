package Medium;

import java.util.HashMap;

/**
 * Created by Jingchao Zhang
 * Date: 2020-11-08
 * Time: 12:26 PM
 */
public class P473_MatchstickstoSquare {

    public HashMap<Pair<Integer, Integer>, Boolean> memo = new HashMap<>();

    public int[] nums;

    public int side;

    public boolean recurse(Integer mask, Integer sidesDone) {
        int total = 0;
        int L = this.nums.length;

        Pair<Integer, Integer> memoKey = new Pair<>(mask, sidesDone);
        for (int i = L - 1; i >= 0; i--) {
            if ((mask & (1 << i)) == 0) {
                total += this.nums[L - 1 - i];
            }
        }
        if (total > 0 && total % this.side == 0) {
            sidesDone++;
        }
        if (sidesDone == 3) {
            return true;
        }
        if (this.memo.containsKey(memoKey)) {
            return this.memo.get((memoKey));
        }
        boolean ans = false;
        int c = total / this.side;
        int rem = this.side * (c + 1) - total;
        for (int i = L - 1; i >= 0; i--) {
            if (this.nums[L - 1 - i] <= rem && (mask & (1 << i)) > 0) {
                if (recurse(mask ^ (1 << i), sidesDone)) {
                    ans = true;
                    break;
                }
            }
        }
        this.memo.put(memoKey, ans);
        return ans;
    }

    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int L = nums.length;
        int perimeter = 0;
        for (int num : nums) {
            perimeter += num;
        }
        if (perimeter % 4 != 0) {
            return false;
        }
        this.nums = nums;
        this.side = perimeter / 4;
        return this.recurse((1 << L) - 1, 0);
    }
}
