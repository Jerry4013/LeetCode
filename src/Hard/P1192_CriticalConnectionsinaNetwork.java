package Hard;

import java.util.*;

public class P1192_CriticalConnectionsinaNetwork {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> connection : connections) {
            Integer node1 = connection.get(0);
            Integer node2 = connection.get(1);
            List<Integer> list = graph.getOrDefault(node1, new ArrayList<>());
            list.add(node2);
            graph.put(node1, list);
            list = graph.getOrDefault(node2, new ArrayList<>());
            list.add(node1);
            graph.put(node2, list);
        }

        for (List<Integer> connection : connections) {
            removeConnection(graph, connection);
            Integer node1 = connection.get(0);
            Integer node2 = connection.get(1);
            HashSet<Integer> visited = new HashSet<>();
            if (!dfs(graph, node1, node2, visited)) {
                ans.add(connection);
            }
            pushBackConnection(graph, connection);
        }
        return ans;
    }

    private boolean dfs(HashMap<Integer, List<Integer>> graph, Integer node1, Integer node2, HashSet<Integer> visited) {
        List<Integer> list = graph.get(node1);
        if (list.contains(node2)) {
            return true;
        }
        for (Integer neighbour : list) {
            if (!visited.contains(neighbour)) {
                visited.add(neighbour);
                if (dfs(graph, neighbour, node2, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void removeConnection(HashMap<Integer, List<Integer>> graph, List<Integer> connection) {
        Integer node1 = connection.get(0);
        Integer node2 = connection.get(1);
        List<Integer> list = graph.get(node1);
        list.remove(node2);
        graph.put(node1, list);
        list = graph.get(node2);
        list.remove(node1);
        graph.put(node2, list);
    }

    private void pushBackConnection(HashMap<Integer, List<Integer>> graph, List<Integer> connection) {
        Integer node1 = connection.get(0);
        Integer node2 = connection.get(1);
        List<Integer> list = graph.get(node1);
        list.add(node2);
        graph.put(node1, list);
        list = graph.get(node2);
        list.add(node1);
        graph.put(node2, list);
    }

    public static void main(String[] args) {
        ArrayList<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(1, 0));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(3, 2));
        connections.add(Arrays.asList(4, 2));
        connections.add(Arrays.asList(4, 3));
        connections.add(Arrays.asList(3, 0));
        connections.add(Arrays.asList(4, 0));
        List<List<Integer>> lists = new P1192_CriticalConnectionsinaNetwork().criticalConnections(5, connections);
        System.out.println("lists = " + lists);
    }
}
