package Interview.Expedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jingchao Zhang
 * Date: 2021-01-24
 * Time: 2:15 PM
 */
public class P3 {
    public int prison(int n, int m, List<Integer> h, List<Integer> v) {
        Collections.sort(h);
        Collections.sort(v);
        int max_h = findMax(h);
        int max_v = findMax(v);
        return max_h * max_v;
    }

    private int findMax(List<Integer> missing) {
        int max = 1;
        if (missing.size() > 0) {
            int start = missing.get(0) - 1;
            int end = missing.get(0) + 1;
            max = Math.max(max, end - start);
            for (int i = 1; i < missing.size(); i++) {
                if (missing.get(i) - missing.get(i - 1) == 1) {
                    end = missing.get(i) + 1;
                    max = Math.max(max, end - start);
                } else {
                    start = missing.get(i) - 1;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> h = new ArrayList<>();
        h.add(4);
        List<Integer> v = new ArrayList<>();
        v.add(2);
        int prison = new P3().prison(6, 6, h, v);
        System.out.println("prison = " + prison);
    }
}
