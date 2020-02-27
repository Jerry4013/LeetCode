package Medium;

import java.util.ArrayList;
import java.util.List;

public class P144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }

    private void preorder(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }
        ans.add(node.val);
        preorder(node.left, ans);
        preorder(node.right, ans);
    }
}
