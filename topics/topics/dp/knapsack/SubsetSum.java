package dp.knapsack;

public class SubsetSum {

    public static void main(String[] args) {

        int[] arr = {1,1,2,3,4};
        int sum = 4; //4 , (112) (13) (13)

        SubsetSum subsetSum = new SubsetSum();
        System.out.println(subsetSum.find(arr, sum, arr.length));
        System.out.println(subsetSum.findDp(arr, sum));
    }

    private boolean findDp(int[] arr, int sum) {
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
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

//        return dp[n][sum];


        return true;
    }

    private boolean find(int[] arr, int sum, int n) {
        if (n == 0 || sum < 0) {
            return false;
        }
        if (sum == 0) return true;

        if (sum >= arr[n - 1]) {
            return find(arr, sum - arr[n - 1], n - 1) || find(arr, sum, n - 1);
        } else {
            return find(arr, sum, n - 1);
        }
    }

    /*
            dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j]


    * */

}
