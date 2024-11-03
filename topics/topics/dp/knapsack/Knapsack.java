package dp.knapsack;

import java.util.Arrays;

public class Knapsack {

    public static void main(String[] args) {

        int[] values = {5, 2, 3};
        int[] weight = {1, 5, 1};

        int N = 3;
        int W = 4;
        Knapsack knapsack = new Knapsack();
        System.out.println(knapsack.findOptimalWeight(values, weight, N - 1, W));

        int[][] dp = new int[N+1][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(knapsack.findOptimalWeight(dp, values, weight, N, W));

        System.out.println(knapsack.findOptimalWeightBottomUp(values, weight, N, W));
    }

    private int findOptimalWeightBottomUp(int[] values, int[] weight, int N, int W) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= W; i++) {
            dp[0][i] = 0;
        }

        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= W; w++) {
                if (weight[n-1] <= w) {
                    dp[n][w] = Integer.max(values[n-1] + dp[n - 1][w - weight[n-1]], dp[n - 1][w]);
                } else {
                    dp[n][w] = dp[n - 1][w];
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[N][W];
    }


    //top-down approach.
    private int findOptimalWeight(int[][] dp, int[] values, int[] weight, int n, int w) {

        if (n <= 0 || w <= 0) return 0;

        if (dp[n][w] != -1) return dp[n][w];

        if (w >= weight[n-1]) {
            dp[n][w] = Integer.max(values[n-1] + findOptimalWeight(dp, values, weight, n - 1, w - weight[n-1]),
                    findOptimalWeight(dp, values, weight, n - 1, w));
        } else {
            dp[n][w] = findOptimalWeight(dp, values, weight, n - 1, w);
        }
        return dp[n][w];
    }

    //recursive approach.
    public int findOptimalWeight(int[] values, int[] weight, int N, int W) {

        if (N < 0 || W == 0) {
            return 0;
        }

        if (weight[N] <= W) {

            int a = values[N] + findOptimalWeight(values, weight, N - 1, W - weight[N]);
            int b = findOptimalWeight(values, weight, N - 1, W);
            return Integer.max(a, b);
        } else {
            int c = findOptimalWeight(values, weight, N - 1, W);
            return c;
        }
    }

}
