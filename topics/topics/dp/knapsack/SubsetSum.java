package dp.knapsack;

public class SubsetSum {

    public static void main(String[] args) {

        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;

        SubsetSum subsetSum = new SubsetSum();
        System.out.println(subsetSum.find(arr, sum, arr.length - 1));

        boolean[][] dp = new boolean[sum + 1][arr.length];
        System.out.println(subsetSum.find(dp, arr, sum, arr.length - 1));
    }

    private boolean find(boolean[][] dp, int[] arr, int sum, int i) {

        if (i < 0 || sum < 0) return false;

        if (sum == 0) return true;

        if (dp[sum][i]) return dp[sum][i];

        if (arr[i] <= sum) {
            dp[sum][i] = find(dp, arr, sum - arr[i], i - 1) || find(dp, arr, sum, i - 1);
        } else {
            dp[sum][i] = find(dp, arr, sum, i - 1);
        }

        return dp[sum][i];
    }

    private boolean find(int[] arr, int sum, int i) {

        if (i < 0 || sum < 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }
        if (sum >= arr[i]) {
            return find(arr, sum - arr[i], i - 1) || find(arr, sum, i - 1);
        } else {
            return find(arr, sum, i - 1);
        }
    }

}
