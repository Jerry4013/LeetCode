package Medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Jingchao Zhang
 * Date: 2020-12-28
 * Time: 1:41 PM
 */
public class P754 {
    public int reachNumber(int target) {
        Set<Integer> memo = new HashSet<>();
        int currStep = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int position = q.remove();
                if (position == target) {
                    return currStep;
                }
                if (memo.contains(position)) {
                    continue;
                }
                memo.add(position);
                q.add(position - (currStep + 1));
                q.add(position + (currStep + 1));
            }
            currStep++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = new P754().reachNumber(2);
        System.out.println("i = " + i);
    }
}
