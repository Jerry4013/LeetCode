package Medium;

public class P287_FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        boolean[] exist = new boolean[nums.length - 1];
        for (int num : nums) {
            if (exist[num - 1]) {
                return num;
            }
            exist[num - 1] = true;
        }
        return -1;
    }
}
