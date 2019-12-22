package Medium;

public class P6_ZigZagConversion {
    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        int step = numRows == 1 ? 1 : (numRows - 1) * 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int j = i;
            if (i == 0 || i == numRows - 1) {
                while (j < chars.length) {
                    sb.append(chars[j]);
                    j += step;
                }
            } else {
                while (j < chars.length) {
                    sb.append(chars[j]);
                    int mid = j + step - 2 * i;
                    if (mid < chars.length) {
                        sb.append(chars[mid]);
                    }
                    j += step;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new P6_ZigZagConversion().convert("A", 1);
        System.out.println("s = " + s);
    }
}
