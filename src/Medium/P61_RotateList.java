package Medium;

public class P61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        tail.next = head;
        int steps = length - k % length - 1;
        ListNode newTail = head;
        for (int i = 0; i < steps; i++) {
            newTail = newTail.next;
        }
        ListNode ans = newTail.next;
        newTail.next = null;
        return ans;
    }
}
