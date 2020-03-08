package Contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P5354 {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            List<Integer> list = map.getOrDefault(manager[i], new ArrayList<>());
            list.add(i);
            map.put(manager[i], list);
        }
        return help(headID, map, informTime);

    }

    private int help(int node, HashMap<Integer, List<Integer>> map, int[] informTime) {
        int max = 0;
        List<Integer> list = map.getOrDefault(node, new ArrayList<>());
        for (Integer employee : list) {
            max = Math.max(max, help(employee, map, informTime));
        }
        return max + informTime[node];
    }

    public static void main(String[] args) {
        int i = new P5354().numOfMinutes(7, 6, new int[]{1,2,3,4,5,6,-1}, new int[]{0,6,5,4,3,2,1});
        System.out.println("i = " + i);
    }

}
