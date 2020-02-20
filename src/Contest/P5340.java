package Contest;

public class P5340 {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int index = firstNegative(grid[m - 1], n);
        int count = n - index ;
        for (int i = m - 2; i >= 0; i--) {
            while (index < n && grid[i][index] >= 0) {
                index++;
            }
            count += n - index;
        }
        return count;
    }

    private int firstNegative(int[] lastLine, int n) {
        int l = 0, r = n - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if (lastLine[mid] < 0 && (mid == 0 || lastLine[mid - 1] >= 0)) {
                return mid;
            } else if (lastLine[mid] >= 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[][] test = {{5,1,0},{-5,-5,-5}};
        int i = new P5340().countNegatives(test);

    }
}
