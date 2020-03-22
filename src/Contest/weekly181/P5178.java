package Contest.weekly181;

public class P5178 {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            int numberOfDivisors = 0;
            int sum = 0;
            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    if (i * i < num) {
                        sum += i + num / i;
                        numberOfDivisors += 2;
                    } else {
                        numberOfDivisors++;
                    }
                }
            }
            if (numberOfDivisors == 4) {
                ans += sum;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = new P5178().sumFourDivisors(new int[]{26});
        System.out.println("i = " + i);
    }
}
