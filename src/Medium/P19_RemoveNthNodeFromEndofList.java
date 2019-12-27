package Medium;


public class P19_RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode detector = head;
        for (int i = 0; i < n; i++) {
            detector = detector.next;
        }
        if (detector == null) {
            return head.next;
        }
        ListNode curr = head;
        while (detector.next != null) {
            curr = curr.next;
            detector = detector.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}
