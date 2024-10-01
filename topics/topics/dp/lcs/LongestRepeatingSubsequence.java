package dp.lcs;

import java.util.Arrays;

public class LongestRepeatingSubsequence {
    //longest subsequence - where no characters in the str1 should have same index as characters in string2.
    public static void main(String[] args) {
        String s = "AABEBCDD";
        LongestRepeatingSubsequence lrs = new LongestRepeatingSubsequence();
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        lrs.topDown(dp, s, s);
        System.out.println();
        for (int[] arr : dp) {
            for (int i : arr) {
                if (i == -1) {
                    System.out.print("0 ");
                } else {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }

        /*

           A A B E B C D D
         0 0 0 0 0 0 0 0 0
      A  0 0 1 1 1 1 1 1 0
      A  0 1 1 1 1 1 1 1 0
      B  0 1 1 1 1 2 2 2 0
      E  0 1 1 1 1 2 2 2 0
      B  0 1 1 2 2 2 2 2 0
      C  0 1 1 2 2 2 2 2 0
      D  0 1 1 2 2 2 2 0 3
      D  0 0 0 0 0 0 0 3 3

        */

    }

    public int topDown(int[][] dp, String s1, String s2) {
        return topDown(dp, s1, s1.length(), s2, s2.length());
    }

    private int topDown(int[][] dp, String x, int i, String y, int j) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (x.charAt(i - 1) == y.charAt(j - 1) && (i - 1) != j - 1) {
            dp[i][j] = 1 + topDown(dp, x, i - 1, y, j - 1);
        } else {
            dp[i][j] = Integer.max(topDown(dp, x, i - 1, y, j), topDown(dp, x, i, y, j - 1));
        }
        return dp[i][j];
    }
}
