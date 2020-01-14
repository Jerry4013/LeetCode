package Contest;

import java.util.*;

public class P5309 {
    public int makeConnected(int n, int[][] connections) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] connection : connections) {
            List<Integer> list = map.getOrDefault(connection[0], new ArrayList<>());
            list.add(connection[1]);
            map.put(connection[0], list);
            list = map.getOrDefault(connection[1], new ArrayList<>());
            list.add(connection[0]);
            map.put(connection[1], list);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(i) == null) {

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] connections = {{0,1},{0,2},{1,2}};
        int i = new P5309().makeConnected(4, connections);
        System.out.println("i = " + i);
    }
}
