package Contest.biweekly44;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Jingchao Zhang
 * Date: 2021-01-23
 * Time: 10:14 AM
 */
public class P5646 {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            List<Set<Integer>> langSets = new ArrayList<>();
            for (int[] language : languages) {
                Set<Integer> set = new HashSet<>();
                for (int lang : language) {
                    set.add(lang);
                }
                langSets.add(set);
            }
            int teach = 0;
            for (int[] friend: friendships) {
                Set<Integer> set1 = langSets.get(friend[0] - 1);
                Set<Integer> set2 = langSets.get(friend[1] - 1);
                Set<Integer> intersection = new HashSet<>(set1);
                intersection.retainAll(set2);
                if (intersection.isEmpty()) {
                    if (set1.contains(i)) {
                        set2.add(i);
                        teach++;
                    } else if (set2.contains(i)) {
                        set1.add(i);
                        teach++;
                    } else {
                        set1.add(i);
                        set2.add(i);
                        teach += 2;
                    }
                }
            }
            ans = Math.min(ans, teach);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] languages = {{2},{1,3},{1,2},{3}};
        int[][] friendships = {{1,4},{1,2},{3,4},{2,3}};
        int i = new P5646().minimumTeachings(3, languages, friendships);
        System.out.println("i = " + i);
    }
}
