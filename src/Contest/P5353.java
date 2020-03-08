package Contest;

public class P5353 {
    public int numTimesAllBlue(int[] light) {
        int sum = 0;
        int realSum = 0;
        int count = 0;
        for (int i = 0; i < light.length; i++) {
            sum += i + 1;
            realSum += light[i];
            if (sum == realSum) {
                count++;
            }
        }
        return count;
    }
}
