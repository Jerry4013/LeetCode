package Interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Jingchao Zhang
 * Date: 2020-11-10
 * Time: 7:00 PM
 */
class Solution {

    List<String> ans  = new ArrayList<>();
    Set<String> used = new HashSet<>();
    int size;

    public static void main(String[] args) {
        System.out.println("Hello, World");
        List<String> test = new ArrayList<>();
        test.add("blue red");
        test.add("red violet");
        test.add("cyan blue");
        test.add("blue magenta");
        test.add("magenta cyan");
        System.out.println(new Solution().coloredStick(test));
    }

    public List<String> coloredStick(List<String> input) {
        size = input.size();
        for (int i = 0; i < size; i++) {
            ans  = new ArrayList<>();
            String stick = input.get(i);
            used.add(stick);
            ans.add(stick);
            String[] ends = stick.split(" ");
            if (backtrack(ends[0], input) || backtrack(ends[1], input)) {
                return ans;
            }
            used.remove(stick);
        }
        System.out.println("IMPOSSIBLE");
        return null;
    }

    // end : "blue"
    public boolean backtrack(String end, List<String> input) {
        if (used.size() == size) {
            return true;
        }
        int size = input.size();
        for (int i = 0; i < size; i++) {
            String remaining = input.get(i);
            if (used.contains(remaining)) {
                continue;
            }
            String[] remaining_ends = remaining.split(" ");
            if (remaining_ends[0].equals(end) || remaining_ends[1].equals(end)) {
                ans.add(remaining);
                used.add(remaining);
                if (backtrack(remaining_ends[1], input)) {
                    return true;
                }
                used.remove(remaining);
                ans.remove(remaining);
            }
        }
        return false;
    }
}

