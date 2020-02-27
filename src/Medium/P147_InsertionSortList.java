package Medium;

public class P147_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.val <= curr.next.val) {
                curr = curr.next;
                continue;
            }
            ListNode n = curr.next;
            curr.next = curr.next.next;
            ListNode icur = dummy;
            while (icur.next.val < n.val) {
                icur = icur.next;
            }
            n.next = icur.next;
            icur.next = n;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        ListNode listNode = new P147_InsertionSortList().insertionSortList(head);

    }
}
