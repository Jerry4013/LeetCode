package Contest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class P5323 {
    public int[] sortByBits(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            int i = n;
            int count = 0;
            while (i != 0) {
                if ((i & 1) == 1) {
                    count++;
                }
                i = i >> 1;
            }
            map.put(n, count);
        }
        Integer[] arrInt = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrInt[i] = arr[i];
        }
        Arrays.sort(arrInt, (o1, o2) -> {
            Integer n1 = map.get(o1);
            Integer n2 = map.get(o2);
            if (!n1.equals(n2)) {
                return n1 - n2;
            }
            return o1 - o2;
        });
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arrInt[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = new P5323().sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println("ints = " + Arrays.toString(ints));
    }
}
