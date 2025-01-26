package dp.stocks;

import java.util.Arrays;

public class BuyAndSellInfiniteTimes {
    public static void main(String[] args) {
        BuyAndSellInfiniteTimes bs = new BuyAndSellInfiniteTimes();
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(bs.maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
        //int sol2 = dpSolution(prices);
        return memoizeSolution(prices);
    }

    private int memoizeSolution(int[] prices) {
        int index = 0;
        int buyTicker = 1;
        int[][] memo = new int[prices.length + 1][2];
        for (int[] m : memo) Arrays.fill(m, -1);
        return calculateProfit(memo, prices, index, buyTicker);
    }

    public int calculateProfit(int[][] memo, int[] prices, int index, int buyTicker) {
        if (index == prices.length) return 0;

        if (memo[index][buyTicker] != -1) return memo[index][buyTicker];

        if (buyTicker == 1) {

            return memo[index][buyTicker] = Integer.max(
                    -prices[index] + calculateProfit(memo, prices, index + 1, 1 - buyTicker),
                    calculateProfit(memo, prices, index + 1, buyTicker));
        } else {
            return memo[index][buyTicker] = Integer.max(
                    prices[index] + calculateProfit(memo, prices, index + 1, 1 - buyTicker),
                    calculateProfit(memo, prices, index + 1, buyTicker));
        }
    }


}
