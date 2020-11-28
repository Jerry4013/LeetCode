package Contest.biweekly40;

/**
 * Created by Jingchao Zhang
 * Date: 2020-11-28
 * Time: 10:17 AM
 */
public class P5557 {
    public int maxRepeating(String sequence, String word) {
        int ans = 0;
        int idx = sequence.indexOf(word);
        while (idx >= 0) {
            int k = 1;
            sequence = sequence.substring(idx + word.length());
            while (sequence.length() > 0 && sequence.startsWith(word)) {
                k++;
                sequence = sequence.substring(word.length());
            }
            ans = Math.max(ans, k);
            idx = sequence.indexOf(word);
        }
        return ans;
    }
}
