package Interview.Expedia;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jingchao Zhang
 * Date: 2021-01-24
 * Time: 1:58 PM
 */
public class P1 {
    public String[] deviceNamesSystem(String[] devicenames) {
        Map<String, Integer> map = new HashMap<>();
        String[] ans = new String[devicenames.length];
        for (int i = 0; i < devicenames.length; i++) {
            if (!map.containsKey(devicenames[i])) {
                ans[i] = devicenames[i];
                map.put(devicenames[i], 1);
            } else {
                int count = map.get(devicenames[i]);
                ans[i] = devicenames[i] + count;
                map.put(devicenames[i], count + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] test = {"switch", "tv", "switch", "tv", "switch", "tv"};
        String[] strings = new P1().deviceNamesSystem(test);
        System.out.println("strings = " + Arrays.toString(strings));
    }
}
