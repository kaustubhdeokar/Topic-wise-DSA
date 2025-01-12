package dp.lcs;

public class C_LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String s1 = "agbcba";
        String s2 = new StringBuilder(s1).reverse().toString();
        System.out.println("s1:" + s1);
        System.out.println("s2:" + s2);
        C_LongestPalindromicSubsequence palindrome = new C_LongestPalindromicSubsequence();
        palindrome.palindromicCase(s1, s2);
    }


    private void palindromicCase(String s1, String s2) {

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int maxMatch = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxMatch = Integer.max(maxMatch, dp[i][j]);
                } else {
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(maxMatch);
    }

}
