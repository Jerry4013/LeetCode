package Medium;

public class P92_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }
        ListNode con = prev, tail = cur;
        ListNode next;
        while (n > 0) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            n--;
        }

        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }
        tail.next = cur;
        return head;
    }
}
