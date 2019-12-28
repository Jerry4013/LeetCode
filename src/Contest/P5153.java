package Contest;

public class P5153 {
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        int depth = findDepth(root);
        dfs(root, 1, depth);
        return sum;
    }

    private int findDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(findDepth(root.left), findDepth(root.right)) + 1;
    }

    private void dfs(TreeNode node, int depth, int target) {
        if (node == null) {
            return;
        }
        if (depth == target) {
            sum += node.val;
            return;
        }
        dfs(node.left, depth + 1, target);
        dfs(node.right, depth + 1, target);
    }
}
