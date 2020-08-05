package Contest.weekly183;

public class P5377 {
    public int numSteps(String s) {
        boolean carry = false;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!carry && s.charAt(i) == '1' && i != 0) {
                carry = true;
                count += 2;
            } else if (!carry && s.charAt(i) == '0') {
                count++;
            } else if (carry && s.charAt(i) == '0') {
                count += 2;
            } else if (carry && s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int i = new P5377().numSteps("10");
        System.out.println("i = " + i);
    }
}
