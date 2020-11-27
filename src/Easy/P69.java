package Easy;

/**
 * Created by Jingchao Zhang
 * Date: 2020-11-15
 * Time: 9:12 AM
 */
public class P69 {
    public int mySqrt(int x) {
        for (int i = 0; i * i <= x; i++) {
            if ((i + 1) * (i + 1) > x || (i + 1) * (i + 1) < 0) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int i = new P69().mySqrt(2147395600);
        System.out.println("i = " + i);
    }
}
