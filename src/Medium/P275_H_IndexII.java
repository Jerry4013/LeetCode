package Medium;

public class P275_H_IndexII {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (citations[mid] >= n - mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return citations[l] >= n - l ? n - l : 0;
    }

    public static void main(String[] args) {
        int i = new P275_H_IndexII().hIndex(new int[]{99,100});
        System.out.println("i = " + i);
    }
}
