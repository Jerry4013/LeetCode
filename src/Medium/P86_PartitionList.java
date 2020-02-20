package Medium;

public class P86_PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode greater = new ListNode(0);
        if (head == null) {
            return null;
        }
        ListNode lessCurr = less;
        ListNode greaterCurr = greater;
        while (head != null) {
            if (head.val < x) {
                lessCurr.next = head;
                lessCurr = lessCurr.next;
            } else {
                greaterCurr.next = head;
                greaterCurr = greaterCurr.next;
            }
            head = head.next;
        }
        greaterCurr.next = null;
        lessCurr.next = greater.next;
        return less.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode partition = new P86_PartitionList().partition(head, 3);
        System.out.println("partition = " + partition);
    }
}
