package Hard;

public class P25_Reverse_Nodes_in_k_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = findTail(head, k);
        ListNode before = dummy;
        while (tail != null) {
            ListNode after = tail.next;
            ListNode prev = before;
            ListNode current = head;
            ListNode next = current.next;
            while (current != after) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }
            before.next = prev;
            before = head;
            head.next = after;
            head = head.next;
            tail = findTail(head, k);
        }
        return dummy.next;
    }

    private ListNode findTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int count = 1;
        ListNode current = head;
        while (current.next != null && count != k) {
            current = current.next;
            count++;
        }
        if (count == k) {
            return current;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode curr = head;
        curr.next = new ListNode(2);
//        curr = curr.next;
//        curr.next = new ListNode(3);
//        curr = curr.next;
//        curr.next = new ListNode(4);
//        curr = curr.next;
//        curr.next = new ListNode(5);
        ListNode listNode = new P25_Reverse_Nodes_in_k_Group().reverseKGroup(head, 2);
    }
}
