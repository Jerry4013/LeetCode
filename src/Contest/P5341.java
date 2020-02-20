package Contest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P5341 {
    List<Integer> list;
    List<Integer> p;

    public P5341() {
        list = new ArrayList<>();
        p = new ArrayList<>();
    }

    public void add(int num) {
        list.add(num);
        p.add(num);
        int size = p.size();
        for (int i = 0; i < size - 1; i++){
            p.set(i, p.get(i) * num);
        }
    }

    public int getProduct(int k) {
        return p.get(p.size() - k);
    }
}
