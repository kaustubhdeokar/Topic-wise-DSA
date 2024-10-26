package dp.lcs;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {

        String s1 = "abcdgh";
        String s2 = "abedfhr";

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.recursive(s1, s2));
        System.out.println(lcs.topDown(s1, s2));

        lcs.pallindromicCase();

    }

    private void pallindromicCase() {
        String s1 = "agbcba";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s1.length() - 1; i >= 0; i--) {
            stringBuilder.append(s1.charAt(i));
        }
        String s2 = stringBuilder.toString();
        System.out.println("s1:" + s1);
        System.out.println("s2:" + s2);

        int matches = topDown(s1, s2);
        System.out.println(matches);

    }

    public int recursive(String s1, String s2) {
        return recursive(s1, s1.length(), s2, s2.length());
    }

    private int recursive(String x, int i, String y, int j) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (x.charAt(i - 1) == y.charAt(j - 1)) {
            return 1 + recursive(x, i - 1, y, j - 1);
        } else {
            return Integer.max(recursive(x, i - 1, y, j), recursive(x, i, y, j - 1));
        }
    }

    public int[][] topDownReturnsArr(String x, String y){
        int xlen = x.length();
        int ylen = y.length();
        int[][] dp = new int[xlen + 1][ylen + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        topDown(dp, x, xlen, y, ylen);
        return dp;
    }

    public int topDown(String x, String y) {
        int[][] dp = topDownReturnsArr(x, y);
        return dp[x.length()][y.length()];
    }

    private int topDown(int[][] dp, String x, int xitr, String y, int yitr) {
        if (xitr <= 0 || yitr <= 0) return 0;

        if (dp[xitr][yitr] != -1) {
            return dp[xitr][yitr];
        }

        if (x.charAt(xitr - 1) == y.charAt(yitr - 1)) {
            dp[xitr][yitr] = 1 + topDown(dp, x, xitr - 1, y, yitr - 1);
        } else {
            dp[xitr][yitr] = Integer.max(topDown(dp, x, xitr - 1, y, yitr), topDown(dp, x, xitr, y, yitr - 1));
        }
        return dp[xitr][yitr];
    }

}
