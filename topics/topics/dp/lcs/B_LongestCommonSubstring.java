package dp.lcs;

public class B_LongestCommonSubstring {
    public static void main(String[] args) {
        String x = "abcco";
        String y = "abdcc";

        B_LongestCommonSubstring lcs = new B_LongestCommonSubstring();
        lcs.recursive(x, y);
        System.out.println("tabulation res:" + lcs.tabulation(x, y));

    }

    private int tabulation(String x, String y) {
        int xLen = x.length();
        int yLen = y.length();
        int[][] dp = new int[xLen + 1][yLen + 1];

        int max = -1;
        for (int i = 1; i <= xLen; i++) {
            for (int j = 1; j <= yLen; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = dp[i][j] > max ? dp[i][j] : max;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return max;
    }

    private void recursive(String x, String y) {
        int[] maxYet = new int[]{0};
        recursive(x, x.length(), y, y.length(), maxYet);
        System.out.println("recursion res:" + maxYet[0]);

    }

    private int recursive(String x, int xLen, String y, int yLen, int[] maxYet) {
        if (xLen == 0 || yLen == 0) return 0;

        if (x.charAt(xLen - 1) == y.charAt(yLen - 1)) {
            int midRes = 1 + recursive(x, xLen - 1, y, yLen - 1, maxYet);
            maxYet[0] = Integer.max(maxYet[0], midRes);
            return midRes;
        } else {
            recursive(x, xLen, y, yLen - 1, maxYet);
            recursive(x, xLen - 1, y, yLen, maxYet);
            return 0;
        }

    }


}