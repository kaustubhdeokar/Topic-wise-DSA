package dp.lcs;

public class ShortestCommonSuperSequence {

    //shortest string encompassing both s1 and s2.
    //calculate scs.  scs = s1.length() + s2.length() - lcs



    public static void main(String[] args) {

        String s1 = "bcacaaab";
        String s2 = "bbabaccc";
        ShortestCommonSuperSequence scss = new ShortestCommonSuperSequence();
        String subsequence = scss.longestCommonSubsequence(s1, s2);
        System.out.println("subsequence:"+subsequence);
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
        int[][] dp = new int[m][n];
        lcs(dp, s1, s2, m - 1, n - 1);
        return constructLCS(dp, s1, s2, m - 1, n - 1);
    }

    private String constructLCS(int[][] dp, String x, String y, int x1, int y1) {

        StringBuilder res = new StringBuilder();
        while (x1 >= 0 && y1 >= 0) {
            if (x.charAt(x1) == y.charAt(y1)) {
                res.append(x.charAt(x1));
                x1 -= 1;
                y1 -= 1;
            } else if (x1 > 0 && y1 > 0) {
                if (dp[x1 - 1][y1] > dp[x1][y1 - 1]) {
                    x1 -= 1;
                } else {
                    y1 -= 1;
                }
            }
            else{
                if(x1>y1){
                    x1-=1;
                }
                else{
                    y1-=1;
                }
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
