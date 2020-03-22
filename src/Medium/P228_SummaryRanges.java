package Medium;

import java.util.ArrayList;
import java.util.List;

public class P228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i == nums.length - 1) {
                list.add(sb.toString());
                break;
            }
            boolean isRange = false;
            while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                if (!isRange) {
                    sb.append("->");
                }
                isRange = true;
                i++;
            }
            if (isRange) {
                sb.append(nums[i]);
            }
            list.add(sb.toString());
            sb.setLength(0);
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> strings = new P228_SummaryRanges().summaryRanges(new int[]{0,2,3,4,6,8,9});
        System.out.println("strings = " + strings);
    }
}
