package Contest.biweekly39;

import java.util.Arrays;

/**
 * Created by Jingchao Zhang
 * Date: 2020-11-14
 * Time: 10:55 AM
 */
public class P5551 {
    public int minimumDeletions(String s) {
        char[] chars = s.toCharArray();
        int[] count_a = new int[chars.length];
        int[] count_b = new int[chars.length];
        int[] pq = new int[chars.length * 2];
        int a = 0;
        int b = 0;
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a') {
                count_a[i] = b;
                sum += b;
            } else {
                b++;
            }
        }
        for (int i = chars.length - 1; i >= 0 ; i--) {
            if (chars[i] == 'b') {
                count_b[i] = a;
                sum += a;
            } else {
                a++;
            }
        }
        System.arraycopy(count_a, 0, pq, 0, chars.length);
        System.arraycopy(count_b, 0, pq, chars.length, chars.length);
        Arrays.sort(pq);
        int ans = 0;
        for (int i = pq.length - 1; i >= 0; i--) {
            if (sum == 0) {
                return ans;
            }
            sum -= pq[i] * 2;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        new P5551().minimumDeletions("aababbab");
    }
}
