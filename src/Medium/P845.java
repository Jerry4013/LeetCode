package Medium;

/**
 * Created by Jingchao Zhang
 * Date: 2020-11-16
 * Time: 8:38 AM
 */
public class P845 {
    public int longestMountain(int[] A) {
        int ans = 0;
        int status = 1;
        int cur = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                if (status == 0) {
                    cur++;
                } else if (status == 1) {
                    cur = 2;
                } else {
                    ans = Math.max(ans, cur);
                    cur = 2;
                }
                status = 0;
            } else if (A[i] == A[i - 1]) {
                if (status == 2) {
                    ans = Math.max(ans, cur);
                }
                status = 1;
                cur = 0;
            } else {
                if (status == 0 || status == 2 && cur > 1) {
                    cur++;
                }
                if (i == A.length - 1) {
                    ans = Math.max(ans, cur);
                }
                status = 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = new P845().longestMountain(new int[]{0,1,2,3,4,5,4,3,2,1,0});
        System.out.println("i = " + i);
    }
}
