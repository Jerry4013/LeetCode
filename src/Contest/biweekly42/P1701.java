package Contest.biweekly42;

/**
 * Created by Jingchao Zhang
 * Date: 2020-12-26
 * Time: 11:08 AM
 */
public class P1701 {
    public double averageWaitingTime(int[][] customers) {
        int total = 0;
        int t = 0;
        for (int[] customer : customers) {
            t = Math.max(t, customer[0]);
            total += t + customer[1] - customer[0];
            t += customer[1];
        }
        return total / (double) customers.length;
    }
}
