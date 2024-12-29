package dp.knapsack;

import java.util.Arrays;

public class Knapsack1 {

    public static void main(String[] args) {

        int[] values = {5, 2, 3};
        int[] weight = {1, 5, 1};

        int N = 3;
        int W = 4;

        Knapsack1 knapsack = new Knapsack1();

        System.out.println(knapsack.withRecursion(N, W, values, weight));

        System.out.println(knapsack.withMemoization(N, W, values, weight));

        System.out.println(knapsack.withTabulation(N, W, values, weight));
    }

    public int withRecursion(int N, int W, int[] values, int[] weight) {
        if (N <= 0) return 0;
        if (W >= weight[N - 1]) {
            return Integer.max(
                    withRecursion(N - 1, W - weight[N - 1], values, weight) + values[N - 1],
                    withRecursion(N - 1, W, values, weight));
        } else {
            return withRecursion(N - 1, W, values, weight);
        }
    }

    private int withMemoization(int N, int W, int[] values, int[] weight) {
        int[][] memo = new int[N + 1][W + 1];
        for (int[] m : memo) Arrays.fill(m, -1);
        return withMemoization(memo, N, W, values, weight);
    }

    public int withMemoization(int[][] memo, int N, int W, int[] values, int[] weight) {
        if (N <= 0) return 0;
        if (memo[N][W] != -1) return memo[N][W];

        if (W >= weight[N - 1]) {
            memo[N][W] = Integer.max(
                    withMemoization(memo, N - 1, W - weight[N - 1], values, weight) + values[N - 1],
                    withMemoization(memo, N - 1, W, values, weight));
        } else {
            memo[N][W] = withMemoization(memo, N - 1, W, values, weight);
        }
        return memo[N][W];
    }

    private int withTabulation(int N, int W, int[] values, int[] weight) {

        int[][] dp = new int[N + 1][W + 1];

        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= W; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (j >= weight[i - 1]) {
                    dp[i][j] = Integer.max(dp[i - 1][j - weight[i - 1]] + values[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
//        printArr(N, W, dp);
        return dp[N][W];
    }

    private static void printArr(int N, int W, int[][] dp) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

}
