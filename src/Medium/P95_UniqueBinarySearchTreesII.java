package Medium;

import java.util.LinkedList;
import java.util.List;

public class P95_UniqueBinarySearchTreesII {

    public LinkedList<TreeNode> generate_trees(int start, int end) {
        LinkedList<TreeNode> all_trees = new LinkedList<>();
        if (start > end) {
            all_trees.add(null);
            return all_trees;
        }
        for (int i = start; i <= end; i++) {
            LinkedList<TreeNode> left_trees = generate_trees(start, i - 1);
            LinkedList<TreeNode> right_trees = generate_trees(i + 1, end);
            for (TreeNode l: left_trees) {
                for (TreeNode r: right_trees) {
                    TreeNode current_tree = new TreeNode(i);
                    current_tree.left = l;
                    current_tree.right = r;
                    all_trees.add(current_tree);
                }
            }
        }
        return all_trees;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generate_trees(1, n);
    }


}
