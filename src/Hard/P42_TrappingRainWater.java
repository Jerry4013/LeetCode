package Hard;

public class P42_TrappingRainWater {
    public int trap(int[] height) {
        int i = 0, j = height.length - 1, ans = 0, bound = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                if (height[i] > bound) {
                    bound = height[i++];
                } else {
                    ans += bound -  height[i++];
                }
            } else {
                if (height[j] > bound) {
                    bound = height[j--];
                } else {
                    ans += bound - height[j--];
                }
            }
        }
        return ans;
    }
}
