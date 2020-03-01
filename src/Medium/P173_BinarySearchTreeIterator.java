package Medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class P173_BinarySearchTreeIterator {

    List<Integer> list = new ArrayList<>();
    Iterator<Integer> iterator;

    public P173_BinarySearchTreeIterator(TreeNode root) {
        inOrder(root);
        iterator = list.iterator();
    }

    /** @return the next smallest number */
    public int next() {
        return iterator.next();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return iterator.hasNext();
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.build("7,3,15,null,null,9,20");
        P173_BinarySearchTreeIterator p173_binarySearchTreeIterator = new P173_BinarySearchTreeIterator(root);
    }

}
