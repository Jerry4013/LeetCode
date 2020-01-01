package Medium;

public class P3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128];
        for (int end = 0, start = 0; end < n; end++) {
            start = Math.max(index[s.charAt(end)], start);
            ans = Math.max(ans, end - start + 1);
            index[s.charAt(end)] = end + 1;
        }
        return ans;
    }
}
