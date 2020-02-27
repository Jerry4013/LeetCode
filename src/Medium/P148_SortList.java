package Medium;

public class P148_SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(mid));
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (n1 != null && n2 != null) {
            if (n1.val > n2.val) {
                ListNode tmp = n1;
                n1 = n2;
                n2 = tmp;
            }
            pre.next = n1;
            n1 = n1.next;
            pre = pre.next;
        }
        pre.next = n1 != null ? n1 : n2;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode listNode = new P148_SortList().sortList(head);
    }
}
