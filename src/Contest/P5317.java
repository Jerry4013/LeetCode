package Contest;

public class P5317 {
    boolean testAgain = false;
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        do {
            testAgain = false;
            dfs(root, target);
        } while (testAgain);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }

    private void dfs(TreeNode node, int target) {
        if (node == null) {
            return;
        }
        dfs(node.left, target);
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null && node.left.val == target) {
                node.left = null;
                testAgain = true;
            }
        }
        if (node.right != null) {
            if (node.right.left == null && node.right.right == null && node.right.val == target) {
                node.right = null;
                testAgain = true;
            }
        }
        dfs(node.right, target);
    }
}
