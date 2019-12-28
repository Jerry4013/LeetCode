package Medium;

public class P24_SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode next = cur.next.next.next;
            cur.next = cur.next.next;
            cur.next.next = first;
            cur.next.next.next = next;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
