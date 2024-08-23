package dp.unboundedknapsack;

import java.util.Arrays;

public class RodCutting {
    public static void main(String[] args) {
        RodCutting rodCutting = new RodCutting();
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        //1  2  3  4  5   6   7   8
        int n = price.length;
        System.out.println(rodCutting.maxProfit(price, n, price.length));

        int[][] dp = new int[n+1][n+1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        System.out.println(rodCutting.maxProfit(dp, price, n, price.length));
    }

    private int maxProfit(int[] price, int n, int length) {

//        System.out.println("n:" + n + " length:" + length);
        if (n == 0) return 0;
        //n = 8, length = 8
        if (length >= n) {
            return Integer.max(price[n - 1] + maxProfit(price, n, length - n), maxProfit(price, n - 1, length));
        } else {
            return maxProfit(price, n - 1, length);
        }
    }

    private int maxProfit(int[][] dp, int[] price, int n, int length) {

         System.out.println("n:" + n + " length:" + length);
        if (n == 0) return 0;

        if (dp[n][length] != -1) {
            return dp[n][length];
        }

        //n = 8, length = 8
        if (length >= n) {
            dp[n][length] = Integer.max(price[n - 1] + maxProfit(dp, price, n, length - n), maxProfit(dp, price, n - 1, length));
        } else {
            dp[n][length] = maxProfit(dp, price, n - 1, length);
        }
        return dp[n][length];
    }

}
