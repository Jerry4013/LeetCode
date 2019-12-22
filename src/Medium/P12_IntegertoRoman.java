package Medium;

public class P12_IntegertoRoman {
    StringBuilder sb = new StringBuilder();
    public String intToRoman(int num) {
        if (num >= 1000) {
            for (int i = 0; i < num / 1000; i++) {
                sb.append('M');
            }
            num = num % 1000;
        }
        convert (num, 100, 'C', 'D', 'M');
        num %= 100;
        convert (num, 10, 'X', 'L', 'C');
        num %= 10;
        convert (num, 1, 'I', 'V', 'X');
        return sb.toString();
    }

    private void convert (int num, int divisor, char one, char five, char ten) {
        if (num >= divisor) {
            int currentDigit = num / divisor;
            if (currentDigit <= 3) {
                for (int i = 0; i < currentDigit; i++) {
                    sb.append(one);
                }
            } else if (currentDigit == 4 || currentDigit == 9) {
                sb.append(one);
                if (currentDigit == 4) {
                    sb.append(five);
                } else {
                    sb.append(ten);
                }
            } else {
                sb.append(five);
                for (int i = 0; i < currentDigit - 5; i++) {
                    sb.append(one);
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = new P12_IntegertoRoman().intToRoman(1994);
        System.out.println("s = " + s);
    }
}
