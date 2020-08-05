package Contest.biweekly23;

public class P5360 {
    public int countLargestGroup(int n) {
        int[] counts = new int[36];
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int temp = i;
            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }
            counts[sum - 1]++;
        }
        int maxSize = counts[0];
        int ans = 1;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > maxSize) {
                maxSize = counts[i];
                ans = 1;
            } else if (counts[i] == maxSize) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = new P5360().countLargestGroup(24);
        System.out.println("i = " + i);
    }
}
