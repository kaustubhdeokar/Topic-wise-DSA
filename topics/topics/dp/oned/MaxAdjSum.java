package dp.oned;

import java.util.Arrays;

public class MaxAdjSum {

    static int solveUtil(int n, int[] arr, int[] dp) {
        dp[0] = arr[0];
        dp[1] = Math.max(dp[0], dp[1]);
        for (int i = 2; i < n; i++) {
            int pick = arr[i] + dp[i - 2];
            int nonPick = dp[i - 1];
            dp[i] = Math.max(pick, nonPick);
        }
        return dp[n - 1];
    }

    static int solve(int n, int[] arr) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solveUtil(n, arr, dp);
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 4, 9};
        int n = arr.length;
        int result = solve(n, arr);
        System.out.println(result);
    }
}
