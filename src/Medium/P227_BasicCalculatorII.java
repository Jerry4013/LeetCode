package Medium;

import java.util.Stack;

public class P227_BasicCalculatorII {
    public int calculate(String s) {
        int digit = 0;
        char operator = '+';
        int[] temp = new int[s.length()];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ' && i < s.length() - 1) {
                continue;
            }
            if (c >= '0' && c <= '9') {
                digit = digit * 10 + (c - '0');
                if (i < s.length() - 1) {
                    continue;
                }
            }
            switch (operator) {
                case '+': temp[index++] = digit; break;
                case '-': temp[index++] = -digit; break;
                case '*': temp[index - 1] *= digit; break;
                case '/': temp[index - 1] /= digit; break;
            }
            operator = c;
            digit = 0;
        }
        int result = 0;
        for (int i = 0; i < temp.length; i++) {
            result += temp[i];
        }
        return result;
    }


    public static void main(String[] args) {
        int calculate = new P227_BasicCalculatorII().calculate(" 3/2 ");
        System.out.println("calculate = " + calculate);
    }
}
