package Medium;

/**
 * Created by Jingchao Zhang
 * Date: 2020-12-20
 * Time: 9:14 AM
 */
public class P880 {
    public String decodeAtIndex(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (sb.length() >= K) {
                return Character.toString(sb.charAt(K - 1));
            }
            if (Character.isDigit(c)) {
                String curr = sb.toString();
                sb.append(curr.repeat(Math.max(0, c - '0' - 1)));
            } else {
                sb.append(c);
            }
        }
        return Character.toString(sb.charAt(K - 1));
    }

    public static void main(String[] args) {
        String ha22 = new P880().decodeAtIndex("y959q969u3hb22odq595", 222280369);
        System.out.println("ha22 = " + ha22);
    }
}
