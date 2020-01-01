package Contest;

import java.util.HashSet;
import java.util.Set;

public class P5297 {
    Set<Integer> set = new HashSet<>();
    public boolean canReach(int[] arr, int start) {
        if (set.contains(start)) {
            return false;
        }
        set.add(start);
        if (arr[start] == 0) {
            return true;
        }
        if (start - arr[start] >= 0) {
            if (canReach(arr, start - arr[start])) {
                return true;
            }
        }
        if (start + arr[start] < arr.length) {
            if (canReach(arr, start + arr[start])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = new P5297().canReach(new int[]{3,0,2,1,2}, 2);
        System.out.println(b);
    }
}
