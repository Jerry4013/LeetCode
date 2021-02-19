package Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jingchao Zhang
 * Date: 2021-02-14
 * Time: 9:32 AM
 */
public class P785_Is_Graph_Bipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        set1.add(0);
        for (int i = 0; i < graph.length; i++) {
            if (set1.contains(i)) {
                for (int j : graph[i]) {
                    if (set1.contains(j)) {
                        return false;
                    }
                    set2.add(j);
                }
            } else if (set2.contains(i)) {
                for (int j : graph[i]) {
                    if (set2.contains(j)) {
                        return false;
                    }
                    set1.add(j);
                }
            } else {
                boolean found = false;
                for (int j : graph[i]) {
                    if (set1.contains(j)) {
                        found = true;
                        set2.add(i);
                        break;
                    } else if (set2.contains(j)) {
                        found = true;
                        set1.add(i);
                        break;
                    }
                }
                if (!found) {
                    set1.add(i);
                }
                i--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{3}, {2,4}, {1}, {0,4}, {1,3}};
        boolean bipartite = new P785_Is_Graph_Bipartite().isBipartite(graph);

    }

}
