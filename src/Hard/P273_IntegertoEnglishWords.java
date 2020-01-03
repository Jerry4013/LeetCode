package Hard;

public class P273_IntegertoEnglishWords {
    String[] lessThanTwentyTable = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tensTable = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        if (num >= 1000000000) {
            sb.append(lessThanTwentyTable[num / 1000000000 - 1]);
            sb.append(" Billion");
            num = num % 1000000000;
            if (num > 0) {
                sb.append(" ");
            }
        }
        if (num >= 1000000) {
            sb.append(convertHundreds(num / 1000000));
            sb.append(" Million");
            num = num % 1000000;
            if (num > 0) {
                sb.append(" ");
            }
        }
        if (num >= 1000) {
            sb.append(convertHundreds(num / 1000));
            sb.append(" Thousand");
            num = num % 1000;
            if (num > 0) {
                sb.append(" ");
            }
        }
        if (num > 0) {
            sb.append(convertHundreds(num));
        }
        return sb.toString();
    }

    private String convertHundreds(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= 100) {
            sb.append(lessThanTwentyTable[num / 100 - 1]);
            sb.append(" Hundred");
            num = num % 100;
            if (num > 0) {
                sb.append(" ");
            }
        }
        if (num > 0) {
            if (num < 20) {
                sb.append(lessThanTwentyTable[num - 1]);
            } else {
                sb.append(tensTable[num / 10 - 2]);
                if (num % 10 > 0) {
                    sb.append(" ");
                    sb.append(lessThanTwentyTable[num % 10 - 1]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new P273_IntegertoEnglishWords().numberToWords(12);
        System.out.println("s = " + s);
    }

}
