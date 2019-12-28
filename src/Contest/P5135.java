package Contest;

public class P5135 {
    public int findBestValue(int[] arr, int target) {
        int sum = 0, ans = Integer.MIN_VALUE;
        int diff = Math.abs(target - sum);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (Math.abs(target - sum) < diff) {

            }

            ans = Math.max(ans, arr[i]);

        }
        return ans;
    }
}
