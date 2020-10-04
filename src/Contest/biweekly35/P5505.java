package Contest.biweekly35;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Jingchao Zhang
 * Date: 2020-09-19
 * Time: 11:26 AM
 */
public class P5505 {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] count = new int[nums.length];
        for (int i = 0; i < requests.length; i++) {
            int start = requests[i][0];
            int end = requests[i][1];
            for (int j = start; j <= end; j++) {
                count[j]++;
            }
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < count.length; i++) {
            List<Integer> list = map.getOrDefault(count[i], new ArrayList<>());
            list.add(i);
            map.put(count[i], list);
        }
        Arrays.sort(nums);
        int[] permutation = new int[nums.length];
        int index = 0;
        for (List<Integer> list : map.values()) {
            for (Integer i : list) {
                permutation[i] = nums[index];
                index++;
            }
        }
        int ans = 0;
        for (int i = 0; i < requests.length; i++) {
            int start = requests[i][0];
            int end = requests[i][1];
            for (int j = start; j <= end; j++) {
                ans += permutation[j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[][] requests = {{1,3}, {0, 1}};
        int i = new P5505().maxSumRangeQuery(nums, requests);
        System.out.println("i = " + i);
    }

}
