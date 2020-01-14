package Contest;

public class P5308 {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        while (a != 0 || b != 0 || c != 0) {
            if ((c & 1) == 0) {
                if ((a & 1) == 1) {
                    ans++;
                }
                if ((b & 1) == 1) {
                    ans++;
                }
            } else {
                if ((a & 1) == 0 && (b & 1) == 0) {
                    ans++;
                }
            }
            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = new P5308().minFlips(2, 6, 5);
        System.out.println("i = " + i);
    }
}
