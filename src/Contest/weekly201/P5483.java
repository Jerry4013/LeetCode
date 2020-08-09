package Contest.weekly201;

import Contest.biweekly32.P5469;

/**
 * Created by Jingchao Zhang
 * Date: 2020-08-08
 * Time: 11:06 PM
 */
public class P5483 {
    class Node {
        char val;
        Node next;
        Node prev;
    }
    public String makeGood(String s) {
        Node head = new Node();
        head.next = new Node();
        head.next.prev = head;
        Node curr = head.next;
        for (int i = 0; i < s.length(); i++) {
            curr.val = s.charAt(i);
            curr.next = new Node();
            curr.next.prev = curr;
            curr = curr.next;
        }
        Node tail = curr;
        curr = head.next;

        while (curr != tail && curr.next != tail) {
            if (Math.abs(curr.val - curr.next.val) == 32) {
                curr = curr.prev;
                curr.next = curr.next.next.next;
                curr.next.prev = curr;
            } else {
                curr = curr.next;
            }
        }
        StringBuilder sb = new StringBuilder();
        curr = head.next;
        while (curr != tail) {
            sb.append(curr.val);
            curr = curr.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String leEeetcode = new P5483().makeGood("s");
        System.out.println("leEeetcode = " + leEeetcode);
    }
}
