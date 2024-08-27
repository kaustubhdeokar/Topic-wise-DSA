package dp.lcs;

public class PrintLCS {
    public static void main(String[] args) {
        String s1 = "aggtab";
        String s2 = "gxtxaby";
        PrintLCS printLCS = new PrintLCS();
        System.out.println(printLCS.topDown(s1, s2));
    }

    public String topDown(String x, String y) {
        int[][] dp = new int[x.length()][y.length()];
        topDown(dp, x, x.length() - 1, y, y.length() - 1);
        return calculateLcsString(dp, x, x.length() - 1, y, y.length() - 1);
    }

    private String calculateLcsString(int[][] dp, String x, int x1, String y, int y1) {
        for (int[] arr : dp) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
        }

        StringBuilder res = new StringBuilder();

        while (x1 >= 0 && y1 >= 0) {

            if (x.charAt(x1) == y.charAt(y1)) {
                res.append(x.charAt(x1));
                x1 -= 1;
                y1 -= 1;
            } else if (dp[x1 - 1][y1] > dp[x1][y1 - 1]) {
                x1 -= 1;
            } else {
                y1 -= 1;
            }

        }
        return res.toString();
    }

    private int topDown(int[][] dp, String x, int i, String y, int j) {
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != 0) {
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
    