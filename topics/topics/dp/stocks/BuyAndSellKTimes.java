package dp.stocks;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
//buy twice, sell twice. (must follow order B S B S)

import java.util.Arrays;

public class BuyAndSellKTimes {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 1, 4, 5, 2, 9, 7};
        BuyAndSellKTimes bs = new BuyAndSellKTimes();

        int timesAllowed = 2;
//        bs.recursionSolution(arr, timesAllowed);
        bs.memoizedSolution(arr, timesAllowed);
    }

    public void recursionSolution(int[] arr, int timesAllowed) {
        int N = 0;
        int ticker = 0; // buy = 0 sell 1 - to ensure buy before selling
        int times = 0;
        System.out.println(calculate(arr, N, ticker, times, timesAllowed));
    }

    public int calculate(int[] arr, int N, int ticker, int times, int timesAllowed) {

        if (times == timesAllowed || N == arr.length) return 0;

        if (ticker == 0) {
            //buy or don't buy
            return Integer.max(
                    -arr[N] + calculate(arr, N + 1, 1, times, timesAllowed),
                    calculate(arr, N + 1, 0, times, timesAllowed));
        } else {
            //sell or don't sell
            return Integer.max(
                    arr[N] + calculate(arr, N + 1, 0, times + 1, timesAllowed), // times + 1 only when sold !
                    calculate(arr, N + 1, 1, times, timesAllowed));
        }
    }

    public int memoizedSolution(int[] arr, int transactions) {
        int[][][] memo = new int[arr.length][2][transactions+1];
        for (int[][] twodmemo : memo) {
            for (int[] a : twodmemo)
                Arrays.fill(a, -1);
        }
        int buyTicker = 1;
        int index = 0;
        int currProfit = 0;
        int res = calculate(memo, arr, index, buyTicker, 2);
        System.out.println("res:" + res);
        return res;
    }

    public int calculate(int[][][] dp, int[] arr, int index, int buyTicker, int transactionsRem)
    {
        if (index == arr.length ||  transactionsRem == 0) return 0;

        if (dp[index][buyTicker][transactionsRem] != -1)
        {
            return dp[index][buyTicker][transactionsRem];
        }

        int profit;
        if (buyTicker == 1) {
            int b1 = -arr[index] + calculate(dp, arr, index + 1, 1-buyTicker, transactionsRem);
            int b2 = calculate(dp, arr, index + 1, buyTicker, transactionsRem);
            profit = Integer.max(b1, b2);
        }
        else {
            int s1 = arr[index] + calculate(dp, arr, index + 1, 1-buyTicker, transactionsRem-1);
            int s2 = calculate(dp, arr, index + 1, buyTicker, transactionsRem);
            profit = Integer.max(s1, s2);
        }
        System.out.println("profit at index"+index+" = "+profit);
        return dp[index][buyTicker][transactionsRem] = profit;

    }

}
