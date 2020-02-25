package Medium;

import java.util.ArrayList;

public class P109_ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return arrayListToBST(list, 0, list.size() - 1);
    }

    private TreeNode arrayListToBST(ArrayList<Integer> list, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            return new TreeNode(list.get(l));
        }
        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        TreeNode left = arrayListToBST(list, l, mid - 1);
        TreeNode right = arrayListToBST(list, mid + 1, r);
        node.left = left;
        node.right = right;
        return node;
    }
}
