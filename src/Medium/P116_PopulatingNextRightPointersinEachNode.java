package Medium;
import SpecialStructure.Node;

import java.util.LinkedList;
import java.util.Queue;


public class P116_PopulatingNextRightPointersinEachNode {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = queue.remove();
            if (prev.left != null) {
                queue.add(prev.left);
                queue.add(prev.right);
            }
            for (int i = 1; i < size; i++) {
                Node node = queue.remove();
                prev.next = node;
                prev = prev.next;
                if (node.left != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node connect = new P116_PopulatingNextRightPointersinEachNode().connect(root);
    }
}
