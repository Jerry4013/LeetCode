package Medium;

public class P96_UniqueBinarySearchTrees {
    public int numTrees(int n) {
        return numTrees(1, n);
    }

    private int numTrees(int from, int to) {
        if (from > to) {
            return 0;
        }
        if (from == to) {
            return 1;
        }
        int count = 0;
        for (int i = from; i <= to; i++) {
            int left = numTrees(from, i - 1);
            int right = numTrees(i + 1, to);
            if (left == 0) {
                count += right;
            } else if (right == 0) {
                count += left;
            } else {
                count += left * right;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int i = new P96_UniqueBinarySearchTrees().numTrees(3);
        System.out.println("i = " + i);
    }
}
