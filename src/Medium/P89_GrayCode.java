package Medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class P89_GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1 << n; i++) {
            result.add(i ^ i >> 1);
        }
        return result;
    }
}
