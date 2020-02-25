package Medium;
import SpecialStructure.Node;

import java.util.LinkedList;
import java.util.Queue;

public class P117_PopulatingNextRightPointersinEachNodeII {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (i < size - 1) {
                    poll.next = queue.peek();
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return root;
    }
}
