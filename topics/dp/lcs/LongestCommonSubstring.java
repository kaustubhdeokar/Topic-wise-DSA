package lcs;

import java.util.Arrays;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String x = "abcco";
        String y = "abdcc";

        int[][] dp = new int[x.length() + 1][y.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        lcs.topDown(dp, x, x.length() - 1, y, y.length() - 1);

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

    }

    private int topDown(int[][] dp, String x, int m, String y, int n) {

        if (m == 0 || n == 0) {
            return 0;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (x.charAt(m - 1) == y.charAt(n - 1)) {
            dp[m][n] = 1 + topDown(dp, x, m - 1, y, n - 1);
        } else {
            dp[m][n] = 0;
            topDown(dp, x, m, y, n-1);
            topDown(dp, x, m-1, y, n);
        }
        return dp[m][n];
    }

}