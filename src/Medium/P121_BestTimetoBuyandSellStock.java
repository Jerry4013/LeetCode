package Medium;

public class P121_BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int diff = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            min = Math.min(min, price);
            diff = Math.max(price - min, diff);
        }
        return diff;
    }
}
