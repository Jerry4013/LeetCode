package Hard;

/**
 * Created by Jingchao Zhang
 * Date: 2021-02-06
 * Time: 1:24 PM
 */
public class P273_Integer_to_English_Words {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        if (num / 1000000000 > 0) {
            sb.append(underThousand(num / 1000000000));
            sb.append(" Billion");
            num %= 1000000000;
            if (num > 0) {
                sb.append(" ");
            }
        }
        if (num / 1000000 > 0) {
            sb.append(underThousand(num / 1000000));
            sb.append(" Million");
            num %= 1000000;
            if (num > 0) {
                sb.append(" ");
            }
        }
        if (num / 1000 > 0) {
            sb.append(underThousand(num / 1000));
            sb.append(" Thousand");
            num %= 1000;
            if (num > 0) {
                sb.append(" ");
            }
        }
        sb.append(underThousand(num));
        return sb.toString();
    }

    public String underThousand(int num) {
        if (num > 999) {
            return null;
        }
        String[] map_20 = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] mapTenths = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        StringBuilder sb = new StringBuilder();
        if (num >= 100) {
            sb.append(map_20[num / 100 - 1]);
            sb.append(" Hundred");
            num %= 100;
            if (num > 0) {
                sb.append(" ");
            } else {
                return sb.toString();
            }
        }
        if (num < 20) {
            sb.append(map_20[num - 1]);
        } else {
            sb.append(mapTenths[num / 10 - 1]);
            if (num % 10 > 0) {
                sb.append(" ");
                sb.append(map_20[num % 10 - 1]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new P273_Integer_to_English_Words().numberToWords(101);
        System.out.println("s = " + s);
    }
}
