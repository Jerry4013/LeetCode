package Contest;

import java.util.Arrays;

public class P5312 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0;
        int sum = 0;
        for (int i = arr.length - 1; i >= arr.length - k; i--) {
            sum += arr[i];
        }
        threshold *= k;
        int r = arr.length - 1;
        int l = arr.length - k;
        while (l >= 0) {
            if (sum >= threshold) {
                ans++;
            }
            l--;
            sum -= arr[r];
            if (l >= 0) {
                sum += arr[l];
            }
            r--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = new P5312().numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4);
        System.out.println("i = " + i);
    }
}
