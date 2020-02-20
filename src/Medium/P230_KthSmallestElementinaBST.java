package Medium;

public class P230_KthSmallestElementinaBST {
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return inorder(root);
    }

    private int inorder(TreeNode node){
        if (node == null) {
            return -1;
        }
        int left = inorder(node.left);
        if (left != -1) {
            return left;
        }
        k--;
        if (k == 0) {
            return node.val;
        }
        int right = inorder(node.right);
        if (right != -1) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.build("5,3,6,2,4,null,null,1");
        int i = new P230_KthSmallestElementinaBST().kthSmallest(root, 3);
        System.out.println("i = " + i);
    }
}
