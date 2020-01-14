package Medium;

import java.util.*;

public class P56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Node head = new Node();
        Node curr = head;
        for (int i = 0; i < intervals.length; i++) {
            Node node = new Node();
            node.l = intervals[i][0];
            node.r = intervals[i][1];
            curr.next = node;
            curr = curr.next;
        }
        curr = head.next;
        int count = 1;
        while (curr.next != null) {
            if (curr.r >= curr.next.l) {
                curr.r = Math.max(curr.r, curr.next.r);
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
                count++;
            }
        }
        curr = head.next;
        int[][] ans = new int[count][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i][0] = curr.l;
            ans[i][1] = curr.r;
            curr = curr.next;
        }
        return ans;
    }

    static class Node {
        int l;
        int r;
        Node next;
    }
}
