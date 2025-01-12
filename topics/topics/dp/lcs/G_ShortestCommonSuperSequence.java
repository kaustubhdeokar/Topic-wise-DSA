package dp.lcs;

public class G_ShortestCommonSuperSequence {

    //shortest string encompassing both s1 and s2.
    //calculate scs.  scs = s1.length() + s2.length() - lcs


    public static void main(String[] args) {

        String s1 = "brute";
        String s2 = "groot";
        G_ShortestCommonSuperSequence scss = new G_ShortestCommonSuperSequence();
        String subsequence = scss.longestCommonSubsequence(s1, s2);
        // lcsubsequence - rt
        System.out.println("subsequence:" + subsequence);
        // b g r u o o t e
        System.out.println(scss.createSuperSequence(s1, s2, subsequence));
    }

    private String createSuperSequence(String x, String y, String subsequence) {
        int x1 = 0;
        int y1 = 0;
        int k = 0;
        StringBuilder superSeq = new StringBuilder();
        while (x1 < x.length() && y1 < y.length() && k < subsequence.length()) {
            if (x.charAt(x1) == y.charAt(y1) && y.charAt(y1) == subsequence.charAt(k)) {
                superSeq.append(x.charAt(x1));
                x1 += 1;
                y1 += 1;
                k += 1;
            } else if (x.charAt(x1) == subsequence.charAt(k)) {
                superSeq.append(y.charAt(y1));
                y1 += 1;
            } else if (y.charAt(y1) == subsequence.charAt(k)) {
                superSeq.append(x.charAt(x1));
                x1 += 1;
            } else {
                superSeq.append(x.charAt(x1));
                superSeq.append(y.charAt(y1));
                x1 += 1;
                y1 += 1;
            }
        }
        while (x1 < x.length()) {
            superSeq.append(x.charAt(x1));
            x1 += 1;
        }
        while (y1 < y.length()) {
            superSeq.append(y.charAt(y1));
            y1 += 1;
        }
        return superSeq.toString();
    }

    public String longestCommonSubsequence(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();
        A_LongestCommonSubsequence lcs = new A_LongestCommonSubsequence();
        int[][] dp = lcs.topDownReturnsArr(s1, s2);
        for (int[] d : dp) {
            for (int d1 : d) {
                System.out.print(d1 + " ");
            }
            System.out.println();
        }
        return constructLCS(dp, s1, s2, m, n);
    }

    private String constructLCS(int[][] dp, String x, String y, int i, int j) {

        StringBuilder res = new StringBuilder();
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                res.append(x.charAt(i-1));
                i -= 1;
                j -= 1;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i -= 1;
            } else {
                j -= 1;
            }
        }
        return res.reverse().toString();
    }

    private int lcs(int[][] dp, String s1, String s2, int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (dp[m][n] != 0) {
            return dp[m][n];
        }

        if (s1.charAt(m) == s2.charAt(n)) {
            dp[m][n] = 1 + lcs(dp, s1, s2, m - 1, n - 1);
        } else {
            dp[m][n] = Integer.max(lcs(dp, s1, s2, m - 1, n), lcs(dp, s1, s2, m, n - 1));
        }

        return dp[m][n];
    }

}
