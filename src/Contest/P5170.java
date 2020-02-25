package Contest;

import java.util.HashSet;

public class P5170 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        int i = 0;
        while (set.size() > 0) {
            if (leftChild[i] != -1) {
                if (!set.contains(leftChild[i])) {
                    return false;
                }
                set.remove(leftChild[i]);

            }


        }


        return set.size() == 0;
    }


}
