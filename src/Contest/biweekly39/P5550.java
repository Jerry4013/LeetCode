package Contest.biweekly39;

/**
 * Created by Jingchao Zhang
 * Date: 2020-11-14
 * Time: 9:57 AM
 */
public class P5550 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;

        int[] ans = new int[n];
        if (k == 0) {
            return ans;
        }
        for (int i = 0; i < n; i++) {
            if (k > 0) {
                for (int j = 0; j < k; j++) {
                    ans[i] += code[(i + j + 1) % n];
                }
            } else {
                for (int j = 0; j < -k; j++) {
                    ans[i] += code[(i - j - 1 + n) % n];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] decrypt = new P5550().decrypt(new int[]{5, 7, 1, 4}, 3);

    }
}
