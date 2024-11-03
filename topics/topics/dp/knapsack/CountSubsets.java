package dp.knapsack;

public class CountSubsets {

    public static void main(String[] args) {

        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        CountSubsets countSubsets = new CountSubsets();
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

    private int subsetSumDp(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        for (int j = 0; j <= sum; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n][sum];

    }


    public int subsetSum(int[] arr, int sum) {
        int n = arr.length;
        return subsetSum(arr, sum, n);
    }

}
