package Medium;

public class P91_DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[] memo = new int[n + 1];
        memo[n] = 1;
        memo[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            int parseInt = Integer.parseInt(s.substring(i, i + 2));
            memo[i] = parseInt <= 26 ? memo[i + 1] + memo[i + 2] : memo[i + 1];
        }
        return memo[0];
    }

    public static void main(String[] args) {
        int i = new P91_DecodeWays().numDecodings("01");
        System.out.println("i = " + i);
    }
}
