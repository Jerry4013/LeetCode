package Contest.biweekly22;

public class P5348 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int i : arr1) {
            boolean add = true;
            for (int j : arr2) {
                if (Math.abs(i - j) <= d) {
                    add = false;
                    break;
                }
            }
            if (add) {
                count++;
            }
        }
        return count;
    }
}
