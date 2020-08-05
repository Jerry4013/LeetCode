package Contest.biweekly23;

public class P5362 {
    public boolean canConstruct(String s, int k) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int odd = 0;
        for (int c : count) {
            if (c % 2 != 0) {
                odd++;
            }
        }
        return k >= odd && k <= s.length();
    }
}
