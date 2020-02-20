package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBuilder {
    public static LinkedList<Integer> convertStringToList(String input) {
        String[] split = input.split(",");
        LinkedList<Integer> list = new LinkedList<>();
        for (String s : split) {
            if (s.equals("null")) {
                list.add(null);
            } else {
                list.add(Integer.parseInt(s));
            }
        }
        return list;
    }

    public static TreeNode build(String input) {
        LinkedList<Integer> list = convertStringToList(input);
        if (list.size() == 0) {
            return null;
        }
        int size = list.size();
        TreeNode[] treeNodes = new TreeNode[size];
        for (int i = 0; i < size; i++) {
            Integer first = list.removeFirst();
            if (first != null) {
                treeNodes[i] = new TreeNode(first);
            } else {
                treeNodes[i] = null;
            }
        }
        for (int i = 0; i < size; i++) {
            if (treeNodes[i] == null) {
                continue;
            }
            int leftIndex = i * 2 + 1;
            if (leftIndex < size) {
                treeNodes[i].left = treeNodes[leftIndex];
            }
            int rightIndex = i * 2 + 2;
            if (rightIndex < size) {
                treeNodes[i].right = treeNodes[rightIndex];
            }
        }
        return treeNodes[0];
    }
}
