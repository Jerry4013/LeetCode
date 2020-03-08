package Medium;

import java.util.*;

public class P187_RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) {
            return Collections.emptyList();
        }
        int mask = 0xFFFFF;
        boolean[] hashes = new boolean[1 << 20];
        int[] encoded = new int[128];
        encoded['A'] = 0;
        encoded['C'] = 1;
        encoded['G'] = 2;
        encoded['T'] = 3;

        int hash = 0;
        char[] sChars = s.toCharArray();
        Set<String> repeated = new HashSet<>();
        for (int i = 0; i < sChars.length; i++) {
            hash <<= 2;
            hash &= mask;
            hash += encoded[sChars[i]];
            if (i >= 9) {
                if (hashes[hash]) {
                    repeated.add(s.substring(i - 9, i + 1));
                }
                hashes[hash] = true;
            }
        }
        return new ArrayList(repeated);
    }

    public static void main(String[] args) {
        List<String> aaaaaaaaaaaa = new P187_RepeatedDNASequences().findRepeatedDnaSequences("ACGTAAAAAACCCCCC");
        System.out.println("aaaaaaaaaaaa = " + aaaaaaaaaaaa);
    }
}
