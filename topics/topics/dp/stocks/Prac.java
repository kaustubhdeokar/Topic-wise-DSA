package dp.stocks;

import java.util.Arrays;

public class Prac {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4, 7};
        int index = 0;
        int buyTicker = 1;
        int[][] memo = new int[prices.length + 1][2];
        for (int[] m : memo) Arrays.fill(m, -1);
        System.out.println(infiniteBuySell(memo, prices, index, buyTicker));

        int k = 2;
        int[][][] cache = new int[prices.length][2][k+1];
        for(int[][] subCache:cache){
            for(int[] subSubCache: subCache) Arrays.fill(subSubCache, -1);
        }
        System.out.println(atMaxKSells(cache, prices, index, buyTicker, k));
    }

    private static int atMaxKSells(int[][][] cache, int[] prices, int index, int buyTicker, int k) {
        if (index == prices.length || k == 0) return 0;

        if(cache[index][buyTicker][k] !=-1){
            return cache[index][buyTicker][k];
        }

        if (buyTicker == 1) {
            cache[index][buyTicker][k] = Integer.max(
                    -prices[index] + atMaxKSells(cache, prices, index + 1, 1 - buyTicker, k), //buy
                    atMaxKSells(cache, prices, index + 1, buyTicker, k));//don't buy
        }
        else {
            cache[index][buyTicker][k] = Integer.max(
                    prices[index] + atMaxKSells(cache, prices, index + 1, 1 - buyTicker, k-1), // sell
                    atMaxKSells(cache, prices, index + 1, buyTicker, k) //dont sell
            );
        }
        return cache[index][buyTicker][k];
    }

    private static int infiniteBuySell(int[][] memo, int[] prices, int index, int buyTicker) {
        if (index == prices.length) return 0;

        if (memo[index][buyTicker] != -1) {
            return memo[index][buyTicker];
        }

        if (buyTicker == 1) {
            memo[index][buyTicker] = Integer.max(
                    -prices[index] + infiniteBuySell(memo, prices, index + 1, 1 - buyTicker), //buy
                    infiniteBuySell(memo, prices, index + 1, buyTicker));//don't buy
        } else {
            memo[index][buyTicker] = Integer.max(
                    prices[index] + infiniteBuySell(memo, prices, index + 1, 1 - buyTicker), // sell
                    infiniteBuySell(memo, prices, index + 1, buyTicker) //dont sell
            );
        }
        return memo[index][buyTicker];
    }
}
