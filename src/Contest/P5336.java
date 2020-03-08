package Contest;

public class P5336 {
    public String sortString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        while (length > 0) {
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    sb.append((char) (i + 'a'));
                    freq[i]--;
                    length--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (freq[i] > 0) {
                    sb.append((char) (i + 'a'));
                    freq[i]--;
                    length--;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String leetcode = new P5336().sortString("leetcode");
        System.out.println("leetcode = " + leetcode);
    }
}
