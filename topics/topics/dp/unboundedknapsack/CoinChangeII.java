package dp.unboundedknapsack;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change-ii/
public class CoinChangeII {

    public static void main(String[] args) {
        CoinChangeII coinChangeII = new CoinChangeII();
        System.out.println(coinChangeII.recursive(5, new int[]{5, 1, 2}));
        System.out.println(coinChangeII.memoization(500, new int[]{3, 5, 7, 8, 9, 10, 11}));
    }

    public int recursive(int amount, int[] coins) {
        int N = coins.length;
        Arrays.sort(coins);
        return recursive(amount, coins, N);
    }

    public int recursive(int amount, int[] coins, int N) {
        if (amount == 0) return 1;
        if (N <= 0 || amount < 0) return 0;

        if (amount >= coins[N - 1]) {
            return
                    recursive(amount - coins[N - 1], coins, N) +
                            recursive(amount, coins, N - 1);
        } else {
            return recursive(amount, coins, N - 1);
        }

    }

    public int memoization(int amount, int[] coins) {

        int N = coins.length;
        Arrays.sort(coins);
        int[][] memo = new int[N + 1][amount + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                memo[i][j] = -1;
            }
        }
        return memoization(memo, amount, coins, N);

    }

    public int memoization(int[][] memo, int amount, int[] coins, int N) {
        if (amount == 0) return 1;
        if (N <= 0 || amount < 0) return 0;

        if (memo[N][amount] != -1) return memo[N][amount];

        if (amount >= coins[N - 1]) {
            return memo[N][amount] =
                    memoization(memo, amount - coins[N - 1], coins, N) +
                            memoization(memo, amount, coins, N - 1);
        } else {
            return memo[N][amount] =
                    memoization(memo, amount, coins, N - 1);
        }
    }


}
