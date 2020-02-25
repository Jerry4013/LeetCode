package Medium;

import java.util.HashMap;

public class P106_ConstructBinaryTreefromInorderandPostorderTraversal {
    int post_idx;
    int[] postOrder;
    int[] inOrder;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }
        int root_val = postOrder[post_idx];
        TreeNode root = new TreeNode(root_val);
        Integer index = map.get(root_val);
        post_idx--;
        root.right = helper(index + 1, right);
        root.left = helper(left, index - 1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postOrder = postorder;
        this.inOrder = inorder;
        post_idx = postorder.length - 1;
        int idx = 0;
        for (Integer val : inorder) {
            map.put(val, idx++);
        }
        return helper(0, inorder.length - 1);
    }
}
