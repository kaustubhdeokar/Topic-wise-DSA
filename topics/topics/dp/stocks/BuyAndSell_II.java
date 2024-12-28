package dp.stocks;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
//buy twice, sell twice. (must follow order B S B S)

import java.util.Arrays;

public class BuyAndSell_II {

    public static void main(String[] args) {

        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        BuyAndSell_II bs = new BuyAndSell_II();

        int timesAllowed = 2;
        bs.recursionSolution(arr, timesAllowed);
        bs.dpSolution(arr, timesAllowed);
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

    private void dpSolution(int[] arr, int timesAllowed) {
        int[][] dp = new int[arr.length][2];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MIN_VALUE);
        }
        int res = calculate(dp, arr, 0, 0, 0, timesAllowed);
        for (int[] d : dp) {
            for (int d1 : d) {
                System.out.print(d1 + " ");
            }
            System.out.println();
        }
        System.out.println("res:" + res);
    }

    public int calculate(int[][] dp, int[] arr, int N, int ticker, int times, int timesAllowed) {
        if (N == arr.length || times == timesAllowed) return 0;


        if (dp[N][ticker] != Integer.MIN_VALUE) {
            System.out.println("here");
            return dp[N][ticker];
        };

        int profit;

        if (ticker == 0) {
            //buy or don't buy
            profit = Integer.max(
                    -arr[N] + calculate(dp, arr, N + 1, 1, times, timesAllowed),
                    calculate(dp, arr, N + 1, 0, times, timesAllowed));
        }
        else {
            //sell or don't sell
            profit = Integer.max(
                    arr[N] + calculate(dp, arr, N + 1, 0, times + 1, timesAllowed), // times + 1 only when sold !
                    calculate(dp, arr, N + 1, 1, times, timesAllowed));
        }

        return dp[N][ticker] = profit;

    }

}
