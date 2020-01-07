package Contest;

public class P5304 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int temp = arr[start];
            for (int j = start + 1; j <= end ; j++) {
                temp ^= arr[j];
            }
            ans[i] = temp;
        }
        return ans;
    }
}
