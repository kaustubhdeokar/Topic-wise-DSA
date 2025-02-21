package dp.stocks;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
//buy once, sell once, (must buy before selling)
public class BuyAndSell_I {
    public static void main(String[] args) {

        BuyAndSell_I bs = new BuyAndSell_I();
        int res = bs.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println("res:"+res); // expected 5.

    }

    public int maxProfit(int[] prices) {

        int minSoFar = prices[0];
        int maxProfit = 0;

        for(int i=1;i<prices.length;i++){
            maxProfit = Integer.max(maxProfit, prices[i]-minSoFar);
            minSoFar = Integer.min(minSoFar, prices[i]);
        }
        return maxProfit;
    }

}
