package dp;

import java.util.Arrays;

public class LCS {

    public int lcs(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m][n];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return lcs(s1, s2, dp, m - 1, n - 1);

    }

    public int bottomUpLCS(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    System.out.println(s1.charAt(i-1)+" "+s2.charAt(j-1)+" i:"+(i-1)+" j:"+(j-1));
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];

    }

    public int spaceOptimisedLCS(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[2][n + 1];
        for (int i = 0; i < 2; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + 1;
                } else {
                    dp[i % 2][j] = Integer.max(dp[(i - 1) % 2][j], dp[i % 2][j - 1]);
                }
            }
        }
        return Integer.max(dp[0][n], dp[1][n]);
    }

    private int lcs(String s1, String s2, int[][] dp, int m, int n) {
        if (m < 0 || n < 0)
            return 0;
        if (dp[m][n] != -1)
            return dp[m][n];
        if (s1.charAt(m) == s2.charAt(n)) {

            dp[m][n] = 1 + lcs(s1, s2, dp, m - 1, n - 1);
        } else {
            dp[m][n] = Integer.max(lcs(s1, s2, dp, m - 1, n), lcs(s1, s2, dp, m, n - 1));
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
//        System.out.println(lcs.lcs("intention", "execution"));
        System.out.println(lcs.bottomUpLCS("intention", "execution"));
//        System.out.println(lcs.spaceOptimisedLCS("abcde", "ace"));

    }

}
