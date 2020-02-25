package Contest;

public class P5324 {

    private int n;
    private int discount;
    private int[] prices;
    private int sn;

    public P5324(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        this.prices = new int[200];
        for (int i = 0; i < products.length; i++) {
            this.prices[products[i] - 1] = prices[i];
        }
    }

    public double getBill(int[] product, int[] amount) {
        int len = product.length;
        double bill = 0;
        for (int i = 0; i < len; i++) {
            bill += prices[product[i] - 1] * amount[i];
        }
        sn++;
        if (sn % n == 0) {
            bill = bill - discount * bill / 100;
        }
        return bill;
    }
}
