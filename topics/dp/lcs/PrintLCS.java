package lcs;

import java.util.Arrays;

public class PrintLCS {
    public static void main(String[] args) {

        String s1 = "abcdgh";
        String s2 = "abedfhr";

        PrintLCS printLCS = new PrintLCS();
        System.out.println(printLCS.recursive(s1, s2));

        System.out.println(printLCS.topDown(s1, s2));
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

    public String topDown(String x, String y) {
        int[][] dp = new int[x.length() + 1][y.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        StringBuilder ans = new StringBuilder();
        topDown(dp, x, x.length() - 1, y, y.length() - 1, ans);
        return ans.toString();
    }

    private int topDown(int[][] dp, String x, int i, String y, int j, StringBuilder ans) {
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (x.charAt(i) == y.charAt(j)) {
            ans.append(x.charAt(i));
            dp[i][j] = 1 + topDown(dp, x, i - 1, y, j - 1, ans);
        } else {
            dp[i][j] = Integer.max(topDown(dp, x, i - 1, y, j, ans), topDown(dp, x, i, y, j - 1, ans));
        }
        return dp[i][j];
    }

}
    