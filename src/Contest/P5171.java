package Contest;

import java.util.Arrays;

public class P5171 {
    public int[] closestDivisors(int num) {
        int diff = Integer.MAX_VALUE;
        int[] ans = new int[2];
        for (int i = 0; i < 2; i++) {
            int p = num + 1 + i;
            double sqrt1 = Math.sqrt(p);
            int d1 = (int) sqrt1;
            int d2 = (int) sqrt1;
            while (d1 * d2 != p && d1 > 0) {
                if (d1 * d2 < p) {
                    d2++;
                } else {
                    d1--;
                }
            }
            if (d1 == 0) {
                continue;
            }
            if (Math.abs(d1 - d2) < diff) {
                diff = Math.abs(d1 - d2);
                ans[0] = d1;
                ans[1] = d2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = new P5171().closestDivisors(222930011);
        System.out.println("ints = " + Arrays.toString(ints));

    }
}
