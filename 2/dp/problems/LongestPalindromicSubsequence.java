package dp;

public class LongestPalindromicSubsequence {

    public int longestPalindromicSubsequence(String s) {

        String sRev = new StringBuilder(s).reverse().toString();

        int m = s.length();

        int[] dp = new int[m];

        int ans = longestPalSeq(s, sRev, m - 1, m - 1, dp);
        for (int i : dp) {
            System.out.print(i + " ");
        }
        return ans;
    }

    public int longestPalSeq(String s1, String s2, int m, int n, int[] dp) {

        if (m < 0 || n < 0) {
            return 0;
        }

        if (dp[m] != 0) return dp[m];
        if (dp[n] != 0) return dp[n];

        if (s1.charAt(m) == s2.charAt(n)) {
            dp[m] = 1 + longestPalSeq(s1, s2, m - 1, n - 1, dp);
        } else {
            dp[m] = Integer.max(longestPalSeq(s1, s2, m-1, n, dp), longestPalSeq(s1, s2, m, n-1, dp));
        }
        return dp[m];
    }

    public static void main(String[] args) {

        LongestPalindromicSubsequence longestSeq = new LongestPalindromicSubsequence();
        longestSeq.longestPalindromicSubsequence("bbbab");

    }

}
