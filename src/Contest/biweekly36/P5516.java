package Contest.biweekly36;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Jingchao Zhang
 * Date: 2020-10-03
 * Time: 11:03 AM
 */
public class P5516 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Set<String> ans = new HashSet<>();
        ans.add("test");
        ans.add("test2");
        List<String> strings = new ArrayList<>(ans);
        System.out.println("strings = " + strings);
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(234);
        map.put("leslie", list);
        List<Integer> times = map.getOrDefault("abc", new ArrayList<>());

        times.add(23);
        List<Integer> leslie = map.get("abc");
        for (String s : map.keySet()) {

        }
        System.out.println(leslie);
    }
}
