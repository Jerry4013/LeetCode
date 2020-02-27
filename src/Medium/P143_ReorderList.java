package Medium;


import java.util.List;

public class P143_ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = findMid(head);
        ListNode next = mid.next;
        mid.next = null;

        ListNode head2 = reverse(next);
        merge(head, head2);
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private void merge(ListNode head1, ListNode head2) {
        ListNode next = head1.next;
        while (head2 != null) {
            head1.next = head2;
            head1 = head2;
            head2 = next;
            next = head1.next;
        }
    }
}
