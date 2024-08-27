package dp.unboundedknapsack;

import java.util.Arrays;

public class MinNumberOfCoins {

    public static void main(String[] args) {

        int[] coins = new int[]{1, 2, 3};
        int sum = 5;
        MinNumberOfCoins minCoins = new MinNumberOfCoins();
        System.out.println(minCoins.recursiveKnapsack(coins, coins.length - 1, sum));

        long[][] dp = new long[coins.length + 1][sum + 1];
        for (long[] a : dp) {
            Arrays.fill(a, -1);
        }
        System.out.println(minCoins.topDownDp(dp, coins, coins.length - 1, sum));

        System.out.println(minCoins.bottomUp(coins, coins.length, sum));
    }

    public long recursiveKnapsack(int[] coins, int N, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (N < 0 || sum < 0) {
            return Integer.MAX_VALUE;
        }
        if (sum >= coins[N]) {
            return Long.min(recursiveKnapsack(coins, N, sum - coins[N]), recursiveKnapsack(coins, N - 1, sum));
        } else {
            return recursiveKnapsack(coins, N - 1, sum);
        }
    }

    public long topDownDp(long[][] dp, int[] coins, int N, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (N < 0 || sum < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[N][sum] != -1) {
            return dp[N][sum];
        }

        if (sum >= coins[N]) {
            dp[N][sum] = Long.min(topDownDp(dp, coins, N, sum - coins[N]) , topDownDp(dp, coins, N - 1, sum));
        } else {
            dp[N][sum] = topDownDp(dp, coins, N - 1, sum);
        }
        return dp[N][sum];
    }

    public long bottomUp(int[] coins, int N, int sum) {

        long[][] dp = new long[N + 1][sum + 1];

        for (int j = 0; j <= sum; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= coins[i - 1]) {
                    dp[i][j] = Long.min(dp[i][j - coins[i - 1]] , dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[N][sum];
    }

}
