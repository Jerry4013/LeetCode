package Contest;

public class P5307 {
    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        for (int i = 1; i <= n / 2; i++) {
            if (!String.valueOf(i).contains("0") && !String.valueOf(n - i).contains("0")) {
                ans[0] = i;
                ans[1] = n - i;
                return ans;
            }
        }
        return ans;
    }
}
