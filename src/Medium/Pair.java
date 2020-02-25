package Medium;

public class Pair<K, V> {
    K key;
    V value;
    Pair(K a, V b) {
        this.key = a;
        this.value = b;
    }
    public K getKey() {
        return this.key;
    }
    public V getValue() {
        return this.value;
    }
}