public class RodCutting {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4};
        int[] val = new int[]{2, 5, 6, 9};
        int L = 3;

        rodCuttingRecursive(arr, val, L);

        rodCuttingDP(arr, val, L);
    }

    private static int rodCuttingDP(int[] arr, int[] val, int l) {

        int n = arr.length;
        int[][] dp = new int[n + 1][l + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= l; j++) {

                if (j >= arr[i - 1]) {
                    dp[i][j] = Integer.max(val[i - 1] + dp[i][j - arr[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        
        System.out.println(dp[n][l]);
        return dp[n][l];
    }

    private static void rodCuttingRecursive(int[] length, int[] price, int n) {
        System.out.println(knapsack(length, price, n, length.length));
    }


    private static int knapsack(int[] arr, int[] price, int totalLen, int n) {

        if (n == 0 || totalLen == 0) return 0;

        if (totalLen >= arr[n - 1]) {
            return Integer.max(price[n - 1] + knapsack(arr, price, totalLen - arr[n - 1], n),
                    knapsack(arr, price, totalLen, n - 1));
        } else
            return knapsack(arr, price, totalLen, n - 1);

    }

}
