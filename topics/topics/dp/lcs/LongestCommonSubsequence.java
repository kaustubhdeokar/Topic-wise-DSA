package dp.lcs;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {

        String s1 = "abcdgh";
        String s2 = "abedfhr";

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.recursive(s1, s2));
        System.out.println(lcs.topDown(s1, s2));
    }

    public int recursive(String s1, String s2) {
        return recursive(s1, s1.length() - 1, s2, s2.length() - 1);
    }

    public int recursive(String x, int i, String y, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (x.charAt(i) == y.charAt(j)) {
            return 1 + recursive(x, i - 1, y, j - 1);
        } else {
            return Integer.max(recursive(x, i - 1, y, j), recursive(x, i, y, j - 1));
        }
    }

    public int topDown(String x, String y) {
        int[][] dp = new int[x.length() + 1][y.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return topDown(dp, x, x.length() - 1, y, y.length() - 1);
    }

    private int topDown(int[][] dp, String x, int i, String y, int j) {
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (x.charAt(i) == y.charAt(j)) {
            dp[i][j] = 1 + topDown(dp, x, i - 1, y, j - 1);
        } else {
            dp[i][j] = Integer.max(topDown(dp, x, i - 1, y, j), topDown(dp, x, i, y, j - 1));
        }
        return dp[i][j];
    }

}
