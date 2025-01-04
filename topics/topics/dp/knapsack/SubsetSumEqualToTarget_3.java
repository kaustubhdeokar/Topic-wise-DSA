package dp.knapsack;

import java.util.Arrays;
//https://takeuforward.org/data-structure/subset-sum-equal-to-target-dp-14/

//https://takeuforward.org/data-structure/partition-equal-subset-sum-dp-15/
//Partition to equal subset sum - (sum/2)

@SuppressWarnings("DuplicatedCode")
public class SubsetSumEqualToTarget_3 {
    public static void main(String[] args) {

        int[] arr = {2, 3, 6};
        int sum = 5; //4 , (112) (13) (13)

        SubsetSumEqualToTarget_3 subsetSum = new SubsetSumEqualToTarget_3();
        boolean res = subsetSum.recursion(arr, sum, arr.length);
        System.out.println("recursion:" + res);
        res = subsetSum.memoization(arr, sum);
        System.out.println("memoization:" + res);
        res = subsetSum.findDp(arr, sum);
        System.out.println("tabulation:" + res);
    }

    private boolean memoization(int[] arr, int sum) {

        int n = arr.length;
        int[][] memo = new int[n + 1][sum + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        memoization(memo, arr, n, sum);

        //printArr(sum, n, memo);
        return memo[n][sum] > 0;
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

    private boolean recursion(int[] arr, int sum, int n) {
        if (sum == 0) return true;

        if (n <= 0) {
            return false;
        }

        if (sum >= arr[n - 1]) {
            return recursion(arr, sum - arr[n - 1], n - 1) || recursion(arr, sum, n - 1);
        } else {
            return recursion(arr, sum, n - 1);
        }
    }

    private boolean findDp(int[] arr, int sum) {
        int n = arr.length;

        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int j = 0; j <= sum; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
//                System.out.print(dp[i][j] + " ");
            }
//            System.out.println();
        }

        return dp[n][sum];
    }
}
