package Interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jingchao Zhang
 * Date: 2020-09-26
 * Time: 11:37 AM
 */
public class Chemical {
    boolean isReactionBalanced(String s) {
        Map<String, Integer> map = new HashMap<>();
        boolean left = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (s.charAt(i) == '=') {
                left = false;
                sb = new StringBuilder();
                continue;
            }
            if (s.charAt(i) == '+') {
                sb = new StringBuilder();
                continue;
            }
            while (i < s.length() && (Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i)))) {
                sb.append(s.charAt(i));
                i++;
            }
            Map<String, Integer> term = parseTerm(sb.toString());
            for (String key: term.keySet()) {
                if(left) {
                    int curr = map.getOrDefault(key, 0);
                    map.put(key, curr + term.get(key));
                } else {
                    if (!map.containsKey(key)) {
                        return false;
                    }
                    int balance = map.get(key) - term.get(key);
                    if (balance < 0) {
                        return false;
                    }
                    map.put(key, balance);
                }
            }
        }
        for (Integer value : map.values()) {
            if (value > 0) {
                return false;
            }
        }
        return true;
    }

    private Map<String, Integer> parseTerm(String s) {
        Map<String, Integer> term = new HashMap<>();
        int i = 0;
        while (Character.isDigit(s.charAt(i))) {
            i++;
        }
        int coefficient = 1;
        if (i > 0) {
            coefficient = Integer.parseInt(s.substring(0, i));
        }
        String element = "";
        while (i < s.length()) {
            if (Character.isLowerCase(s.charAt(i))) {
                element = element + s.charAt(i);
            } else if (Character.isUpperCase(s.charAt(i))) {
                if (!element.equals("")) {
                    term.put(element, term.getOrDefault(element, 0) + 1);
                }
                element = Character.toString(s.charAt(i));
            } else {
                int start = i;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                int n = Integer.parseInt(s.substring(start, i));
                term.put(element, term.getOrDefault(element, 0) + n);
                i--;
                element = "";
            }
            i++;
        }
        if (!element.equals("")) {
            term.put(element, term.getOrDefault(element, 0) + 1);
        }
        for (String key: term.keySet()) {
            term.put(key, term.get(key) * coefficient);
        }
        return term;
    }


    public static void main(String[] args) {
        Chemical chemical = new Chemical();
        boolean reactionBalanced = chemical.isReactionBalanced("2H2 + O2 = 2H2O");
        System.out.println("reactionBalanced = " + reactionBalanced);
    }
}
