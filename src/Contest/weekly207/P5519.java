package Contest.weekly207;

/**
 * Created by Jingchao Zhang
 * Date: 2020-09-19
 * Time: 10:44 PM
 */
public class P5519 {
    public String reorderSpaces(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                count++;
            }
        }
        String[] words = text.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        if (words.length == 1) {
            sb.append(words[0]);
            for (int i = 0; i < count; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        int space = count / (words.length - 1);
        int end = count % (words.length - 1);

        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (i != words.length - 1) {
                for (int j = 0; j < space; j++) {
                    sb.append(" ");
                }
            } else {
                for (int j = 0; j < end; j++) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new P5519().reorderSpaces("a");
        System.out.println("s = " + s);
    }
}
