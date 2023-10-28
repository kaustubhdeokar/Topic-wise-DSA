public class ShortestCommonSuperSequence {

    public static void main(String[] args) {

        String s1 = "abcc";
        String s2 = "asdc";
        int lcsLength = longestCommonSubsequence(s1, s2);
        System.out.println(s1.length() + s2.length() - lcsLength);

    }

    public static int longestCommonSubsequence(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        return lcs(s1, s2, dp, m, n);

    }

    private static int lcs(String s1, String s2, int[][] dp, int m, int n) {

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

}
