package Medium;

/**
 * Created by Jingchao Zhang
 * Date: 2020-07-17
 * Time: 4:43 PM
 */
public class P2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            if (sum > 9) {
                carry = 1;
                sum %= 10;
            } else {
                carry = 0;
            }
            curr.next = new ListNode(sum);
            curr = curr.next;
        }
        return dummy.next;
    }
}
