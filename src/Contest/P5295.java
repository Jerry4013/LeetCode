package Contest;

public class P5295 {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        ans[0] = 0;
        for (int i = 1; i < n; i++) {
            ans[i] = i % 2 == 0 ? -i + 1 : i;
        }
        if (n % 2 == 0) {
            ans[0] = -ans[n - 1];
        }
        return ans;
    }
}
