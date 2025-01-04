package dp.knapsack;

import java.util.Arrays;

public class CountSubsetsEqualToASum_2 {

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 1, 1};
        int sum = 4;
        CountSubsetsEqualToASum_2 countSubsets = new CountSubsetsEqualToASum_2();
        int count = countSubsets.recursive(arr, sum);
        System.out.println(count);

        count = countSubsets.memoization(arr, sum);
        System.out.println(count);

        count = countSubsets.tabulation(arr, sum);
        System.out.println(count);
    }

    private int memoization(int[] arr, int sum) {
        int n = arr.length;
        int[][] memo = new int[n + 1][sum + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        memoization(memo, arr, n, sum);

        //printArr(sum, n, memo);
        return memo[n][sum];
    }

    private int memoization(int[][] memo, int[] arr, int n, int sum) {

        if (sum == 0) return 1;
        if (n <= 0) return 0;

        if (memo[n][sum] != -1) return memo[n][sum];

        if (sum >= arr[n - 1]) {
            memo[n][sum] = memoization(memo, arr, n - 1, sum - arr[n - 1])
                    + memoization(memo, arr, n - 1, sum);
        } else {
            memo[n][sum] = memoization(memo, arr, n - 1, sum);
        }

        return memo[n][sum];

    }

    private int recursive(int[] arr, int sum, int n) {

        if (sum == 0) return 1;
        if (n <= 0 || sum < 0) return 0;

        if (sum >= arr[n - 1]) {
            return recursive(arr, sum - arr[n - 1], n - 1) + recursive(arr, sum, n - 1);
        } else {
            return recursive(arr, sum, n - 1);
        }

    }

    private int tabulation(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];

        for (int j = 0; j <= sum; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        printArr(sum, n, dp);

        return dp[n][sum];

    }

    private static void printArr(int sum, int n, int[][] dp) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }


    public int recursive(int[] arr, int sum) {
        int n = arr.length;
        return recursive(arr, sum, n);
    }

}
