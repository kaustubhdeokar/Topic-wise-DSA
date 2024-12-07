package dp.knapsack;

public class CountSubsets2 {

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 1, 1};
        int sum = 4;
        CountSubsets2 countSubsets = new CountSubsets2();
        int count = countSubsets.subsetSum(arr, sum);
        System.out.println(count);

        count = countSubsets.subsetSumDp(arr, sum);
        System.out.println(count);
    }

    private int subsetSum(int[] arr, int sum, int n) {

        if (sum == 0) return 1;
        if (n <= 0 || sum < 0) return 0;

        if (sum >= arr[n - 1]) {
            return subsetSum(arr, sum - arr[n - 1], n - 1) + subsetSum(arr, sum, n - 1);
        } else {
            return subsetSum(arr, sum, n - 1);
        }

    }

    private int subsetSumDp(int[] nums, int sum) {
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


    public int subsetSum(int[] arr, int sum) {
        int n = arr.length;
        return subsetSum(arr, sum, n);
    }

}
