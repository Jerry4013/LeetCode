package Medium;

import java.util.HashMap;
import java.util.Map;

public class P146_LRUCache {

    final Node head = new Node();
    final Node tail = new Node();
    Map<Integer, Node> map;
    int cache_capacity;

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }

    public P146_LRUCache(int capacity) {
        map = new HashMap<>(cache_capacity);
        this.cache_capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public void add(Node node) {
        Node head_next = head.next;
        head.next = node;
        node.prev = head;
        node.next = head_next;
        head_next.prev = node;
    }

    public void remove(Node node) {
        Node next_node = node.next;
        Node prev_node = node.prev;
        prev_node.next = next_node;
        next_node.prev = prev_node;
    }

    public int get(int key) {
        int result = -1;
        Node node = map.get(key);
        if (node != null) {
            result = node.val;
            remove(node);
            add(node);
        }
        return result;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            remove(node);
            node.val = value;
            add(node);
        } else {
            if (map.size() == cache_capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;
            map.put(key, newNode);
            add(newNode);
        }
    }
}
