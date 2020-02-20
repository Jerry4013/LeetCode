package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P93_RestoreIPAddresses {

    int n;
    String s;
    LinkedList<String> segments = new LinkedList<>();
    ArrayList<String> output = new ArrayList<>();

    public boolean valid(String segment) {
        int m = segment.length();
        if (m > 3)
            return false;
        return (segment.charAt(0) != '0') ? (Integer.parseInt(segment) <= 255) : (m == 1);
    }

    public void update_output(int curr_pos) {
        String segment = s.substring(curr_pos + 1, n);
        if (valid(segment)) {
            segments.add(segment);
            output.add(String.join(".", segments));
            segments.removeLast();
        }
    }

    public void backtrack(int prev_pos, int dots) {
        int max_pos = Math.min(n - 1, prev_pos + 4);
        for (int curr_pos = prev_pos + 1; curr_pos < max_pos; curr_pos++) {
            String segment = s.substring(prev_pos + 1, curr_pos + 1);
            if (valid(segment)) {
                segments.add(segment);  // place dot
                if (dots - 1 == 0)      // if all 3 dots are placed
                    update_output(curr_pos);  // add the solution to output
                else
                    backtrack(curr_pos, dots - 1);  // continue to place dots
                segments.removeLast();  // remove the last placed dot
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        this.s = s;
        backtrack(-1, 3);
        return output;
    }

    public static void main(String[] args) {
        List<String> strings = new P93_RestoreIPAddresses().restoreIpAddresses("25525511135");
        System.out.println("strings = " + strings);
    }
}









