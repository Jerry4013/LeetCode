package Medium;

import java.util.ArrayList;
import java.util.List;

public class P17_LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        int digit = digits.charAt(0) - '0';
        int keySize = digit < 7 || digit == 8 ? 3 : 4;
        int offset;
        if (digit <= 7) {
            offset = (digit - 2) * 3;
        } else if (digit == 8) {
            offset = 19;
        } else {
            offset = 22;
        }
        for (int i = 0; i < keySize; i++) {
            ans.add(String.valueOf((char)('a' + offset + i)));
        }

        for (int i = 1; i < digits.length(); i++) {
            digit = digits.charAt(i) - '0';
            List<String> list = new ArrayList<>();
            for (int k = 0; k < ans.size(); k++) {
                String s = ans.get(k);
                keySize = digit < 7 || digit == 8 ? 3 : 4;
                if (digit <= 7) {
                    offset = (digit - 2) * 3;
                } else if (digit == 8) {
                    offset = 19;
                } else {
                    offset = 22;
                }
                for (int j = 0; j < keySize; j++) {
                    list.add(s + (char) ('a' + offset + j));
                }
            }
            ans = list;
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> strings = new P17_LetterCombinationsofaPhoneNumber().letterCombinations("7");
        System.out.println("strings = " + strings);
    }
}
