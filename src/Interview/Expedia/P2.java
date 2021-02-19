package Interview.Expedia;

import java.util.List;

/**
 * Created by Jingchao Zhang
 * Date: 2021-01-24
 * Time: 2:54 PM
 */
public class P2 {
    public int minNum(int threshold, List<Integer> points) {

        int l = 1, r =  points.size() - 1;
        int target = threshold + points.get(0);
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (points.get(mid) == target) {
                l = mid;
                break;
            }
            if (points.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }


        return (l + 1) / 2 + 1;
    }

    public static void main(String[] args) {

    }
}
