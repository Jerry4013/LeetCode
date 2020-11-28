package Contest.biweekly40;

import java.util.ArrayDeque;

/**
 * Created by Jingchao Zhang
 * Date: 2020-11-28
 * Time: 10:48 AM
 */
public class P5560 {
    ArrayDeque<Integer> deque1 = new ArrayDeque<>();
    ArrayDeque<Integer> deque2 = new ArrayDeque<>();

    public P5560() {

    }

    public void pushFront(int val) {
        deque1.addFirst(val);
        if (deque1.size() > deque2.size()) {
            deque2.addFirst(deque1.removeLast());
        }
    }

    public void pushMiddle(int val) {
        deque1.addLast(val);
        if (deque1.size() > deque2.size()) {
            deque2.addFirst(deque1.removeLast());
        }
    }

    public void pushBack(int val) {
        deque2.addLast(val);
        if (deque2.size() - deque1.size() == 2) {
            deque1.addLast(deque2.removeFirst());
        }
    }

    public int popFront() {
        int ans = deque1.removeFirst();
        if (deque2.size() - deque1.size() == 2) {
            deque1.addLast(deque2.removeFirst());
        }
        return ans;
    }

    public int popMiddle() {
        if (deque1.size() < deque2.size()) {
            return deque2.removeFirst();
        }
        return deque1.removeLast();
    }

    public int popBack() {
        int ans = deque2.removeLast();
        if (deque1.size() > deque2.size()) {
            deque2.addFirst(deque1.removeLast());
        }
        return ans;
    }
}
