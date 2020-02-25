package Medium;

import java.util.ArrayList;
import java.util.List;

public class P113_PathSumII {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, 0, new ArrayList<>());
        return ans;
    }

    private void dfs(TreeNode node, int sum, int currentSum, List<Integer> tempList) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && sum == currentSum + node.val) {
            tempList.add(node.val);
            ans.add(new ArrayList<>(tempList));
            tempList.remove(tempList.size() - 1);
            return;
        }
        if (node.left != null) {
            tempList.add(node.val);
            dfs(node.left, sum, currentSum + node.val, tempList);
            tempList.remove(tempList.size() - 1);
        }
        if (node.right != null) {
            tempList.add(node.val);
            dfs(node.right, sum, currentSum + node.val, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.build("-2,null,-3");
        List<List<Integer>> lists = new P113_PathSumII().pathSum(root, -5);
        System.out.println("lists = " + lists);
    }
}
