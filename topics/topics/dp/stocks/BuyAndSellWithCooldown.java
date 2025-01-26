package dp.stocks;

import java.util.Arrays;

public class BuyAndSellWithCooldown {

    public static void main(String[] args) {
        BuyAndSellWithCooldown bs = new BuyAndSellWithCooldown();
        bs.maxProfit(new int[]{1, 2, 3, 0, 2});
    }

    public int maxProfit(int[] prices) {
        int index = 0;
        int buyTicker = 1;
        int[][] memo = new int[prices.length + 1][2];
        for (int[] m : memo) Arrays.fill(m, -1);
        return calculateProfit(memo, prices, index, buyTicker);
    }

    public int calculateProfit(int[][] memo, int[] prices, int index, int buyTicker) {
        if (index >= prices.length) return 0;

        if (memo[index][buyTicker] != -1) return memo[index][buyTicker];

        if (buyTicker == 1) {
            return memo[index][buyTicker] = Integer.max(
                    -prices[index] + calculateProfit(memo, prices, index + 1, 1 - buyTicker),
                    calculateProfit(memo, prices, index + 1, buyTicker));
        } else {
            return memo[index][buyTicker] = Integer.max(
                    //ONLY CHANGE FROM INIFINITE BUY AND SELL, AFTER SELLING AS WE CANNOT BUY ON NEXT DAY, INDEX = INDEX+2
                    prices[index] + calculateProfit(memo, prices, index + 2, 1 - buyTicker),
                    calculateProfit(memo, prices, index + 1, buyTicker));
        }
    }
}
