import java.util.Random;

/**
 * Created by Jingchao Zhang
 * Date: 2021-01-16
 * Time: 6:16 PM
 */
public class TestRandom {
    public static void main(String[] args) {
        Random random = new Random();
        int left = 0;
        int right = 5;
        for (int i = 0; i < 30; i++) {
            System.out.println(left + random.nextInt(right - left));
        }
    }
}
