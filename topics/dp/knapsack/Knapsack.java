package knapsack;

import java.util.Arrays;

public class Knapsack {

    public static void main(String[] args) {

        int[] values = {5, 2, 3};
        int[] weight = {1, 5, 1};

        int N = 3;
        int W = 4;
        Knapsack knapsack = new Knapsack();
        System.out.println(knapsack.findOptimalWeight(values, weight, N - 1, W));

        int[][] dp = new int[N][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(knapsack.findOptimalWeight(dp, values, weight, N - 1, W));

    }

    //top-down approach.
    private int findOptimalWeight(int[][] dp, int[] values, int[] weight, int n, int w) {

        if (n < 0 || w == 0) return 0;

        if (dp[n][w] != -1) return dp[n][w];

        if (w >= weight[n]) {
            dp[n][w] = Integer.max(values[n] + findOptimalWeight(dp, values, weight, n - 1, w - weight[n]),
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
