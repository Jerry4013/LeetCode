package Medium;

public class P114_FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        flattenAndGetLeaf(root);
    }

    private TreeNode flattenAndGetLeaf(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode leftLeaf = flattenAndGetLeaf(root.left);
        TreeNode rightLeaf = flattenAndGetLeaf(root.right);
        if (leftLeaf == null) {
            return rightLeaf;
        }
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        if (rightLeaf == null) {
            return leftLeaf;
        }
        leftLeaf.right = right;
        return rightLeaf;
    }

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.build("1,2,null,3");
        new P114_FlattenBinaryTreetoLinkedList().flatten(root);
        System.out.println("done");
    }
}
