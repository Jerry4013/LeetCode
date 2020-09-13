package Contest.weekly206;

/**
 * Created by Jingchao Zhang
 * Date: 2020-09-12
 * Time: 11:27 PM
 */
public class P5512 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[] mem = new int[n];
        for (int i = 0; i < pairs.length; i++) {
            mem[pairs[i][0]] = pairs[i][1];
            mem[pairs[i][1]] = pairs[i][0];
        }
        int ans = 0;

        for (int k = 0; k < pairs.length; k++) {
            int[] pair = pairs[k];
            int[] pOfFirst = preferences[pair[0]];
            f:
            for (int i = 0; i < pOfFirst.length; i++) {
                if (pOfFirst[i] == pair[1]) {
                    break;
                }
                int[] pOfFriend = preferences[pOfFirst[i]];
                for (int j = 0; j < pOfFriend.length; j++) {
                    if (pOfFriend[j] == mem[pOfFirst[i]]) {
                        break;
                    }
                    if (pOfFriend[j] == pair[0]) {
                        ans++;
                        break f;
                    }
                }
            }

            int[] pOfSecond = preferences[pair[1]];
            s:
            for (int i = 0; i < pOfSecond.length; i++) {
                if (pOfSecond[i] == pair[0]) {
                    break;
                }
                int[] pOfFriend = preferences[pOfSecond[i]];
                for (int j = 0; j < pOfFriend.length; j++) {
                    if (pOfFriend[j] == mem[pOfSecond[i]]) {
                        break;
                    }
                    if (pOfFriend[j] == pair[1]) {
                        ans++;
                        break s;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] pre = {{1,3,2},{2,3,0},{1,3,0},{0,2,1}};
        int[][] pairs = {{1,3},{0,2}};
        int i = new P5512().unhappyFriends(4, pre, pairs);
        System.out.println("i = " + i);

    }
}
