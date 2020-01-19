package Contest;

public class P5315 {
    public int maximum69Number (int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '6') {
                chars[i] = '9';
                return Integer.parseInt(new String(chars));
            }
        }
        return num;
    }
}
