package Interview.Expedia;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Jingchao Zhang
 * Date: 2021-01-23
 * Time: 3:48 PM
 */
public class Solution {
    public static void main(String[] args) {
        String sort = new Solution().sort("hello world hello haa ha I");
        System.out.println(sort);
    }

    public String sort(String input) {
        String[] split = input.split(" ");
        Word[] words = new Word[split.length];
        for (int i = 0; i < split.length; i++) {
            words[i] = new Word(i, split[i]);
        }
        Arrays.sort(words, (a, b) -> {
            if (a.content.length() != b.content.length()) {
                return a.content.length() - b.content.length();
            }
            return a.order - b.order;
        });
        return Arrays.stream(words).map(word -> word.content).collect(Collectors.joining(" "));
    }

    static class Word {
        int order;
        String content;
        Word (int order, String content) {
            this.order = order;
            this.content = content;
        }
    }
}
