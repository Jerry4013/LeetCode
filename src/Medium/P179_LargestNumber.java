package Medium;

import java.util.Arrays;
import java.util.Comparator;

public class P179_LargestNumber {
    private static class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String order1 = o1 + o2;
            String order2 = o2 + o1;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(asStrs, new LargerNumberComparator());
        if (asStrs[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String asStr : asStrs) {
            sb.append(asStr);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new P179_LargestNumber().largestNumber(new int[]{121, 12});
        System.out.println("s = " + s);
    }
}
