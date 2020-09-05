package Contest.biweekly34;

/**
 * Created by Jingchao Zhang
 * Date: 2020-09-05
 * Time: 11:11 AM
 */
public class P5492 {
    public int numWays(String s) {
        long n = s.length();
        long m = 1;
        for (int i = 0; i < 9; i++) {
            m *= 10;
        }
        int one = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                one++;
            }
        }
        if (one == 0) {
            return (int)((n - 1) * (n - 2) / 2 % (m + 7));
        }
        if (one % 3 != 0) {
            return 0;
        }
        long curr = 0, l1 = 0, l2 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                curr++;
            }
            if (curr == one / 3) {
                l1++;
            } else if(curr == one * 2 / 3) {
                l2++;
            }
        }
        return (int) (l1 * l2 % (m + 7));
    }

    public static void main(String[] args) {
        int i = new P5492().numWays("10101");
        System.out.println("i = " + i);
    }
}
