package Hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P23_MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKListsCD(lists, 0, lists.length - 1);
    }

    private ListNode mergeKListsCD(ListNode[] lists, int m, int n) {
        if (m == n) {
            return lists[m];
        }
        ListNode left = mergeKListsCD(lists, m, (m + n) / 2);
        ListNode right = mergeKListsCD(lists, (m + n) / 2 + 1, n);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode start = new ListNode(-1);
        ListNode cur = start;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = (left == null) ? right : left;
        return start.next;
    }
}
