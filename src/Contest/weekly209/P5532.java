package Contest.weekly209;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jingchao Zhang
 * Date: 2020-10-03
 * Time: 11:24 PM
 */
public class P5532 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
         this.right = right;
      }
    }
    public static boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean evenLevel = true;
        while(!queue.isEmpty()) {
            TreeNode prev = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (evenLevel && node.val % 2 == 0 || !evenLevel && node.val % 2 == 1) {
                    return false;
                }
                if (prev != null && evenLevel && node.val <= prev.val || prev != null && !evenLevel && node.val >= prev.val) {
                    return false;
                }
                prev = node;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            evenLevel = !evenLevel;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(10);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(12);
        root.left.left.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.right.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(2);
        boolean evenOddTree = isEvenOddTree(root);

    }
}
