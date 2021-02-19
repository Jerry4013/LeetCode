package Medium;

/**
 * Created by Jingchao Zhang
 * Date: 2021-02-18
 * Time: 9:02 PM
 */
public class P413_ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int[] diff = new int[A.length - 1];
        for (int i = 0; i + 1 < A.length; i++) {
            diff[i] = A[i + 1] - A[i];
        }
        int count = 1;
        int ans = 0;
        for (int i = 1; i < diff.length; i++) {
            if (diff[i] == diff[i - 1]) {
                count++;
            } else {
                if (count > 1) {
                    int n = count - 1;
                    ans += n * (n + 1) / 2;
                }
                count = 1;
            }
        }
        if (count > 1) {
            int n = count - 1;
            ans += n * (n + 1) / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = new P413_ArithmeticSlices().numberOfArithmeticSlices(new int[]{1, 2, 3, 4});
        System.out.println("i = " + i);
    }
}
