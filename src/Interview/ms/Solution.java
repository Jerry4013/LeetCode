package Interview.ms;

/**
 * Created by Jingchao Zhang
 * Date: 2021-01-17
 * Time: 1:57 PM
 */
public class Solution {

    // 14行：while (A[first] < 0 && A[last] > 0 && first < last) {
    // 20行：
    String solution(String S) {
        int[] occurrences = new int[26];
        for (char ch : S.toCharArray()) {
            occurrences[ch - 'a']++;
        }

        char best_char = 'a';
        int best_res = 0;

        for (int i = 0; i < 26; i++) {
            if (occurrences[i] > best_res) {
                best_char = (char) ((int)'a' + i);
                best_res = occurrences[i];
            }
        }
        return Character.toString(best_char);
    }
    public static void main(String[] args) {
        String hello = new Solution().solution("abcd");
        System.out.println(hello);

    }
}
