package Contest.biweekly22;

public class P5349 {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int[] counts = new int[n];
        boolean[][] isReserved = new boolean[n][10];
        for (int i = 0; i < n; i++) {
            counts[i] = 2;
        }
        for (int[] seat : reservedSeats) {
            if (counts[seat[0] - 1] == 2 && seat[1] >= 2 && seat[1] <= 9) {
                counts[seat[0] - 1] = 1;
            }
            isReserved[seat[0] - 1][seat[1] - 1] = true;
        }
        for (int i = 0; i < n; i++) {
            if (counts[i] == 2) {
                continue;
            }
            boolean b1 = true, b2 = true, b3 = true;
            for (int j = 1; j < 5; j++) {
                if (isReserved[i][j]) {
                    b1 = false;
                    break;
                }
            }
            for (int j = 3; j < 7; j++) {
                if (isReserved[i][j]) {
                    b2 = false;
                    break;
                }
            }
            for (int j = 5; j < 9; j++) {
                if (isReserved[i][j]) {
                    b3 = false;
                    break;
                }
            }
            if (!b1 && !b2 && !b3) {
                counts[i] = 0;
            }
        }
        int count = 0;
        for (int c : counts) {
            count += c;
        }
        return count;
    }
}
