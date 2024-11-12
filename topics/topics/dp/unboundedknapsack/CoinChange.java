package dp.unboundedknapsack;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {

        int[] coins = new int[]{1, 2, 3};
        int sum = 5;
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.recursiveKnapsack(coins, coins.length, sum));
        System.out.println(coinChange.bottomUp(coins, coins.length, sum));
    }

    public long recursiveKnapsack(int[] coins, int N, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (N <= 0 || sum < 0) {
            return 0;
        }
        if (sum >= coins[N - 1]) {
            return recursiveKnapsack(coins, N, sum - coins[N - 1]) + recursiveKnapsack(coins, N - 1, sum);
        } else {
            return recursiveKnapsack(coins, N - 1, sum);
        }
    }

    public long bottomUp(int[] coins, int N, int sum) {

        long[][] dp = new long[N + 1][sum + 1];

        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= coins[i - 1]) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[N][sum];
    }


}
