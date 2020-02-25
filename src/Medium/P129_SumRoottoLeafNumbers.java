package Medium;

public class P129_SumRoottoLeafNumbers {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null){
            return sum;
        }
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int current) {
        current = current * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += current;
            return;
        }
        if (node.left != null) {
            dfs(node.left, current);
        }
        if (node.right != null) {
            dfs(node.right, current);
        }
    }
}
