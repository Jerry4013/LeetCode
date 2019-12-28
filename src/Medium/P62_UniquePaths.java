package Medium;

public class P62_UniquePaths {
    public int uniquePaths(int m, int n) {
        int a, b;
        if (m > n) {
            a = m - 1;
            b = n - 1;
        } else {
            a = n - 1;
            b = m - 1;
        }

        long res = 1, sum = a + b;
        while (sum > a) {
            res *= sum;
            sum--;
        }
        while (b > 1) {
            res /= b;
            b--;
        }
        return (int) res;
    }
}
