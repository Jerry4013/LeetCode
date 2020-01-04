package Hard;

import java.util.*;

public class P460_LFUCache {

    Map<Integer, Node> map;
    Map<Integer, List<Node>> freq;
    int capacity;

    class Node {
        int key;
        int value;
        int freq;
    }

    public P460_LFUCache(int capacity) {
        map = new HashMap<>(capacity);
        freq = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        int result = -1;
        if (capacity == 0) {
            return result;
        }
        Node node = map.get(key);
        if (node != null) {
            result = node.value;
            increaseFreq(node);
        }
        return result;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            increaseFreq(node);
        } else {
            if (map.size() == capacity) {
                int min = Integer.MAX_VALUE;
                for (Integer freqKey : freq.keySet()) {
                    min = Math.min(min, freqKey);
                }
                List<Node> list = freq.get(min);
                int toRemove = list.get(0).key;
                map.remove(toRemove);
                list.remove(0);
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            newNode.freq = 0;
            map.put(key, newNode);
            increaseFreq(newNode);
        }
    }

    private void increaseFreq(Node node) {
        int freq = node.freq;
        List<Node> list = this.freq.get(freq);
        if (list != null) {
            list.remove(node);
            if (list.size() == 0) {
                this.freq.remove(freq);
            }
        }
        node.freq = freq + 1;
        List<Node> newList = this.freq.get(freq + 1);
        if (newList == null) {
            newList = new ArrayList<>();
        }
        newList.add(node);
        this.freq.put(freq + 1, newList);
    }

    public static void main(String[] args) {
        P460_LFUCache cache = new P460_LFUCache(0);
        cache.put(0, 0);
        int i = cache.get(0);
        System.out.println("i = " + i);
    }
}
