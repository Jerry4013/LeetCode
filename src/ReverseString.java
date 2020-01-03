public class ReverseString {
    public String reverse(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String test = new ReverseString().reverse("asewtest");
        System.out.println("test = " + test);
    }
}
