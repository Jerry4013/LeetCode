package Medium;

import java.util.ArrayList;

public class P138_CopyListwithRandomPointer {
    public Node copyRandomList(Node head) {
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = curr.next.next;
        }
        curr = head;

        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node ans = new Node(0);
        Node copyCurr = ans;
        while (curr != null) {
            copyCurr.next = curr.next;
            copyCurr = copyCurr.next;
            curr.next = curr.next.next;
            curr = curr.next;
        }
        return ans.next;
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}


