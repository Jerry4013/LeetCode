package Medium;

import java.util.ArrayList;
import java.util.List;

public class P60_PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> digits = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            digits.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while (k != 0) {
            int f = factorial(n - 1);
            int index = (k - 1) / f;
            Integer remove = digits.remove(index);
            sb.append((char) ('0' + remove));
            k %= f;
            n--;
        }
        while (digits.size() > 0) {
            sb.append((char) ('0' + digits.remove(digits.size() - 1)));
        }
        return sb.toString();
    }

    private int factorial(int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }

    public static void main(String[] args) {
        String permutation = new P60_PermutationSequence().getPermutation(4, 9);
        System.out.println("permutation = " + permutation);
    }
}
