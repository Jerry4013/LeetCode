package Medium;

import java.util.*;

public class P236_LowestCommonAncestorofaBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        stack.push(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }



    public static void main(String[] args) {
        TreeNode root = TreeBuilder.build("3,5,1,6,2,0,8,null,null,7,4");
        TreeNode p = root.left;
        TreeNode q = root.left.right.right;
        TreeNode treeNode = new P236_LowestCommonAncestorofaBinaryTree().lowestCommonAncestor(root, p, q);

    }
}
