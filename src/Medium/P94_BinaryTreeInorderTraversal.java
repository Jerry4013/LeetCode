package Medium;

import java.util.ArrayList;
import java.util.List;

public class P94_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

    private void inorder(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }
        inorder(node.left, ans);
        ans.add(node.val);
        inorder(node.right, ans);
    }
}
